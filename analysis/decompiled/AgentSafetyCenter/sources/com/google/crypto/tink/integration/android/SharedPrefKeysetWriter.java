package com.google.crypto.tink.integration.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.crypto.tink.KeysetWriter;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.subtle.Hex;
import g5.f;
import java.io.IOException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class SharedPrefKeysetWriter implements KeysetWriter {
    private final SharedPreferences.Editor editor;
    private final String keysetName;

    public SharedPrefKeysetWriter(Context context, String str, String str2) {
        if (str == null) {
            f.s("keysetName cannot be null");
            throw null;
        }
        this.keysetName = str;
        Context applicationContext = context.getApplicationContext();
        if (str2 == null) {
            this.editor = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
        } else {
            this.editor = applicationContext.getSharedPreferences(str2, 0).edit();
        }
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void write(Keyset keyset) throws IOException {
        if (this.editor.putString(this.keysetName, Hex.encode(keyset.toByteArray())).commit()) {
            return;
        }
        od.f.l("Failed to write to SharedPreferences");
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void write(EncryptedKeyset encryptedKeyset) throws IOException {
        if (this.editor.putString(this.keysetName, Hex.encode(encryptedKeyset.toByteArray())).commit()) {
            return;
        }
        od.f.l("Failed to write to SharedPreferences");
    }
}
