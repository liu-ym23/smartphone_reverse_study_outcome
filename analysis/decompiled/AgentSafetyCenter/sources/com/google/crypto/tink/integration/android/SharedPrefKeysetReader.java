package com.google.crypto.tink.integration.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.crypto.tink.KeysetReader;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.subtle.Hex;
import g5.f;
import java.io.CharConversionException;
import java.io.FileNotFoundException;
import k0.a;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class SharedPrefKeysetReader implements KeysetReader {
    private final String keysetName;
    private final SharedPreferences sharedPreferences;

    public SharedPrefKeysetReader(Context context, String str, String str2) {
        if (str == null) {
            f.s("keysetName cannot be null");
            throw null;
        }
        this.keysetName = str;
        Context applicationContext = context.getApplicationContext();
        if (str2 == null) {
            this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        } else {
            this.sharedPreferences = applicationContext.getSharedPreferences(str2, 0);
        }
    }

    private byte[] readPref() throws CharConversionException, FileNotFoundException {
        try {
            String string = this.sharedPreferences.getString(this.keysetName, null);
            if (string != null) {
                return Hex.decode(string);
            }
            throw new FileNotFoundException("can't read keyset; the pref value " + this.keysetName + " does not exist");
        } catch (ClassCastException | IllegalArgumentException unused) {
            throw new CharConversionException(a.C("can't read keyset; the pref value ", this.keysetName, " is not a valid hex string"));
        }
    }

    @Override // com.google.crypto.tink.KeysetReader
    public Keyset read() {
        return Keyset.parseFrom(readPref(), ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.KeysetReader
    public EncryptedKeyset readEncrypted() {
        return EncryptedKeyset.parseFrom(readPref(), ExtensionRegistryLite.getEmptyRegistry());
    }
}
