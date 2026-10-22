package com.android.server.backup;

import android.content.Context;
import android.util.Slog;
import com.android.server.backup.utils.DataStreamCodec;
import com.android.server.backup.utils.DataStreamFileCodec;
import com.android.server.backup.utils.PasswordUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes.dex */
public final class BackupPasswordManager {
    private static final int BACKUP_PW_FILE_VERSION = 2;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_PW_FILE_VERSION = 1;
    private static final String PASSWORD_HASH_FILE_NAME = "pwhash";
    private static final String PASSWORD_VERSION_FILE_NAME = "pwversion";
    public static final String PBKDF_CURRENT = "PBKDF2WithHmacSHA1";
    public static final String PBKDF_FALLBACK = "PBKDF2WithHmacSHA1And8bit";
    private static final String TAG = "BackupPasswordManager";
    private final File mBaseStateDir;
    private final Context mContext;
    private String mPasswordHash;
    private byte[] mPasswordSalt;
    private int mPasswordVersion;
    private final SecureRandom mRng;

    private static final class BackupPasswordHash {
        public String hash;
        public byte[] salt;

        BackupPasswordHash(String hash, byte[] salt) {
            this.hash = hash;
            this.salt = salt;
        }
    }

    private static final class PasswordHashFileCodec implements DataStreamCodec<BackupPasswordHash> {
        /* synthetic */ PasswordHashFileCodec(BackupPasswordManagerIA r1) {
            this();
        }

        private PasswordHashFileCodec() {
        }

        @Override // com.android.server.backup.utils.DataStreamCodec
        public /* bridge */ /* synthetic */ BackupPasswordHash deserialize(DataInputStream r1) throws IOException {
            return deserialize(r1);
        }

        @Override // com.android.server.backup.utils.DataStreamCodec
        public /* bridge */ /* synthetic */ void serialize(BackupPasswordHash r1, DataOutputStream r2) throws IOException {
            serialize2(r1, r2);
        }

        /* JADX INFO: renamed from: serialize, reason: avoid collision after fix types in other method */
        public void serialize2(BackupPasswordHash backupPasswordHash, DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(backupPasswordHash.salt.length);
            dataOutputStream.write(backupPasswordHash.salt);
            dataOutputStream.writeUTF(backupPasswordHash.hash);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.android.server.backup.utils.DataStreamCodec
        public BackupPasswordHash deserialize(DataInputStream dataInputStream) throws IOException {
            int saltLen = dataInputStream.readInt();
            byte[] salt = new byte[saltLen];
            dataInputStream.readFully(salt);
            String hash = dataInputStream.readUTF();
            return new BackupPasswordHash(hash, salt);
        }
    }

    private static final class PasswordVersionFileCodec implements DataStreamCodec<Integer> {
        /* synthetic */ PasswordVersionFileCodec(BackupPasswordManagerIA r1) {
            this();
        }

        private PasswordVersionFileCodec() {
        }

        @Override // com.android.server.backup.utils.DataStreamCodec
        public /* bridge */ /* synthetic */ Integer deserialize(DataInputStream r1) throws IOException {
            return deserialize(r1);
        }

        @Override // com.android.server.backup.utils.DataStreamCodec
        public /* bridge */ /* synthetic */ void serialize(Integer r1, DataOutputStream r2) throws IOException {
            serialize2(r1, r2);
        }

        /* JADX INFO: renamed from: serialize, reason: avoid collision after fix types in other method */
        public void serialize2(Integer integer, DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.write(integer.intValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.android.server.backup.utils.DataStreamCodec
        public Integer deserialize(DataInputStream dataInputStream) throws IOException {
            return Integer.valueOf(dataInputStream.readInt());
        }
    }

    BackupPasswordManager(Context context, File baseStateDir, SecureRandom secureRandom) {
        this.mContext = context;
        this.mRng = secureRandom;
        this.mBaseStateDir = baseStateDir;
        loadStateFromFilesystem();
    }

    boolean hasBackupPassword() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "hasBackupPassword");
        if (this.mPasswordHash != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mPasswordHash.length() <= 0) goto L7;
        return true;
    }

    boolean backupPasswordMatches(String password) {
        if (hasBackupPassword() == true) goto L5;
        return true;
    L5:
        if (passwordMatchesSaved(password) == true) goto L10;
        return false;
    L10:
        return true;
    }

    boolean setBackupPassword(String currentPassword, String newPassword) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "setBackupPassword");
        if (passwordMatchesSaved(currentPassword) == true) goto L23;
        return false;
    L23:
        getPasswordVersionFileCodec().serialize(2);     // Catch: IOException -> L18
        this.mPasswordVersion = 2;     // Catch: IOException -> L18
        if (newPassword == null) goto L17;
        if (newPassword.isEmpty() == true) goto L17;
        byte[] salt = randomSalt();     // Catch: IOException -> L13
        String newPwHash = PasswordUtils.buildPasswordHash(PBKDF_CURRENT, newPassword, salt, 10000);     // Catch: IOException -> L13
        getPasswordHashFileCodec().serialize(new BackupPasswordHash(newPwHash, salt));     // Catch: IOException -> L13
        this.mPasswordHash = newPwHash;     // Catch: IOException -> L13
        this.mPasswordSalt = salt;     // Catch: IOException -> L13
        return true;
    L14:
        Slog.e(TAG, "Unable to set backup password");
        return false;
    L17:
        return clearPassword();
    L19:
        Slog.e(TAG, "Unable to write backup pw version; password not changed");
        return false;
    }

    private boolean usePbkdf2Fallback() {
        if (this.mPasswordVersion >= 2) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean clearPassword() {
        File passwordHashFile = getPasswordHashFile();
        if (passwordHashFile.exists() == true) goto L5;
    L8:
        this.mPasswordHash = null;
        this.mPasswordSalt = null;
        return true;
    L5:
        if (passwordHashFile.delete() == true) goto L8;
        Slog.e(TAG, "Unable to clear backup password");
        return false;
    }

    private void loadStateFromFilesystem() {
        this.mPasswordVersion = getPasswordVersionFileCodec().deserialize().intValue();     // Catch: IOException -> L5
    L14:
        BackupPasswordHash hash = getPasswordHashFileCodec().deserialize();     // Catch: IOException -> L9
        this.mPasswordHash = hash.hash;     // Catch: IOException -> L9
        this.mPasswordSalt = hash.salt;     // Catch: IOException -> L9
        return;
    L10:
        Slog.e(TAG, "Unable to read saved backup pw hash");
        return;
    L6:
        Slog.e(TAG, "Unable to read backup pw version");
        this.mPasswordVersion = 1;
        goto L14
    }

    private boolean passwordMatchesSaved(String candidatePassword) {
        if (passwordMatchesSaved(PBKDF_CURRENT, candidatePassword) == false) goto L5;
    L10:
        return true;
    L5:
        if (usePbkdf2Fallback() == true) goto L7;
    L9:
        return false;
    L7:
        if (passwordMatchesSaved(PBKDF_FALLBACK, candidatePassword) == false) goto L9;
        goto L9
    }

    private boolean passwordMatchesSaved(String algorithm, String candidatePassword) {
        if (this.mPasswordHash != null) goto L9;
        if (candidatePassword != null) goto L6;
    L7:
        return true;
    L6:
        if (candidatePassword.equals("") == true) goto L7;
        return false;
    L9:
        if (candidatePassword != null) goto L11;
    L15:
        return false;
    L11:
        if (candidatePassword.length() == 0) goto L15;
        String candidatePasswordHash = PasswordUtils.buildPasswordHash(algorithm, candidatePassword, this.mPasswordSalt, 10000);
        return this.mPasswordHash.equalsIgnoreCase(candidatePasswordHash);
    }

    private byte[] randomSalt() {
        byte[] array = new byte[512 / 8];
        this.mRng.nextBytes(array);
        return array;
    }

    private DataStreamFileCodec<Integer> getPasswordVersionFileCodec() {
        return new DataStreamFileCodec(new File(this.mBaseStateDir, PASSWORD_VERSION_FILE_NAME), new PasswordVersionFileCodec(null));
    }

    private DataStreamFileCodec<BackupPasswordHash> getPasswordHashFileCodec() {
        return new DataStreamFileCodec(getPasswordHashFile(), new PasswordHashFileCodec(null));
    }

    private File getPasswordHashFile() {
        return new File(this.mBaseStateDir, PASSWORD_HASH_FILE_NAME);
    }
}
