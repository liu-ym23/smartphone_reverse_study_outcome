package com.baidu.mshield.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mshield.utility.g;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.Set;

/* JADX INFO: loaded from: classes39.dex */
public class b implements SharedPreferences.Editor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences.Editor f32432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f32433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f32434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f32435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f32436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f32437f;

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        if (this.f32434c == 1) goto L5;
        return;
    L5:
        if (this.f32436e == true) goto L7;
    L8:
        SharedPreferences.Editor r100 = this.f32432a;
        if (r100 == null) goto L14;
        r100.apply();
        return;
    L14:
        return;
    L7:
        if (TextUtils.isEmpty(this.f32437f) == true) goto L8;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        throw new RuntimeException("This editor not allow to call clear.");
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        if (this.f32434c == 1) goto L5;
    L12:
        return true;
    L5:
        if (this.f32436e == true) goto L7;
    L8:
        SharedPreferences.Editor r100 = this.f32432a;
        if (r100 == null) goto L12;
        return r100.commit();
    L7:
        if (TextUtils.isEmpty(this.f32437f) == false) goto L12;
        goto L8
    }

    public final Bundle a(Bundle r100) {
        com.baidu.mshield.b.c.a.b("SPT callProviderPut:" + r100);     // Catch: Throwable -> L16
        r100.putString("pref_name", this.f32435d);     // Catch: Throwable -> L16
        if (this.f32436e == false) goto L15;
        if (TextUtils.isEmpty(this.f32437f) == false) goto L13;
        return g.a(this.f32433b, "CallPreferences", r100);
    L13:
        return g.a(this.f32433b, "CallPreferences", r100, this.f32437f);
    L15:
        return g.a(this.f32433b, "CallPreferences", r100);
    L16:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        return null;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String r100) {
        throw new RuntimeException("This editor not allow to call remove.");
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String r100, boolean r101) {
    L16:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    L18:
        return this;
    L3:
        if (this.f32434c == 1) goto L5;
    L14:
        Bundle r102 = new Bundle();     // Catch: Throwable -> L16
        r102.putString(WikiFolderPushPlugin.OPT, "putBoolean");     // Catch: Throwable -> L16
        r102.putString("key", r100);     // Catch: Throwable -> L16
        r102.putBoolean("value", r101);     // Catch: Throwable -> L16
        a(r102);     // Catch: Throwable -> L16
        goto L18
    L5:
        if (this.f32436e == false) goto L9;
        if (TextUtils.isEmpty(this.f32437f) == false) goto L14;
    L9:
        if (this.f32432a != null) goto L11;
        return this;
    L11:
        com.baidu.mshield.b.c.a.b("SPT putBoolean:put by mBase");     // Catch: Throwable -> L16
        SharedPreferences.Editor r103 = this.f32432a;     // Catch: Throwable -> L16
        if (r103 == null) goto L18;
        r103.putBoolean(r100, r101);     // Catch: Throwable -> L16
        goto L18
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String r100, float r101) {
    L16:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    L18:
        return this;
    L3:
        if (this.f32434c == 1) goto L5;
    L14:
        Bundle r102 = new Bundle();     // Catch: Throwable -> L16
        r102.putString(WikiFolderPushPlugin.OPT, "putFloat");     // Catch: Throwable -> L16
        r102.putString("key", r100);     // Catch: Throwable -> L16
        r102.putFloat("value", r101);     // Catch: Throwable -> L16
        a(r102);     // Catch: Throwable -> L16
        goto L18
    L5:
        if (this.f32436e == false) goto L9;
        if (TextUtils.isEmpty(this.f32437f) == false) goto L14;
    L9:
        if (this.f32432a != null) goto L11;
        return this;
    L11:
        com.baidu.mshield.b.c.a.b("SPT putFloat:put by mBase");     // Catch: Throwable -> L16
        SharedPreferences.Editor r103 = this.f32432a;     // Catch: Throwable -> L16
        if (r103 == null) goto L18;
        r103.putFloat(r100, r101);     // Catch: Throwable -> L16
        goto L18
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String r100, int r101) {
    L16:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    L18:
        return this;
    L3:
        if (this.f32434c == 1) goto L5;
    L14:
        Bundle r102 = new Bundle();     // Catch: Throwable -> L16
        r102.putString(WikiFolderPushPlugin.OPT, "putInt");     // Catch: Throwable -> L16
        r102.putString("key", r100);     // Catch: Throwable -> L16
        r102.putInt("value", r101);     // Catch: Throwable -> L16
        a(r102);     // Catch: Throwable -> L16
        goto L18
    L5:
        if (this.f32436e == false) goto L9;
        if (TextUtils.isEmpty(this.f32437f) == false) goto L14;
    L9:
        if (this.f32432a != null) goto L11;
        return this;
    L11:
        com.baidu.mshield.b.c.a.b("SPT putInt:put by mBase");     // Catch: Throwable -> L16
        SharedPreferences.Editor r103 = this.f32432a;     // Catch: Throwable -> L16
        if (r103 == null) goto L18;
        r103.putInt(r100, r101);     // Catch: Throwable -> L16
        goto L18
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String r100, long r101) {
    L16:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    L18:
        return this;
    L3:
        if (this.f32434c == 1) goto L5;
    L14:
        Bundle r102 = new Bundle();     // Catch: Throwable -> L16
        r102.putString(WikiFolderPushPlugin.OPT, "putLong");     // Catch: Throwable -> L16
        r102.putString("key", r100);     // Catch: Throwable -> L16
        r102.putLong("value", r101);     // Catch: Throwable -> L16
        a(r102);     // Catch: Throwable -> L16
        goto L18
    L5:
        if (this.f32436e == false) goto L9;
        if (TextUtils.isEmpty(this.f32437f) == false) goto L14;
    L9:
        if (this.f32432a != null) goto L11;
        return this;
    L11:
        com.baidu.mshield.b.c.a.b("SPT putLong:put by mBase");     // Catch: Throwable -> L16
        SharedPreferences.Editor r103 = this.f32432a;     // Catch: Throwable -> L16
        if (r103 == null) goto L18;
        r103.putLong(r100, r101);     // Catch: Throwable -> L16
        goto L18
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String r100, String r101) {
    L16:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    L18:
        return this;
    L3:
        if (this.f32434c == 1) goto L5;
    L14:
        Bundle r102 = new Bundle();     // Catch: Throwable -> L16
        r102.putString(WikiFolderPushPlugin.OPT, "putString");     // Catch: Throwable -> L16
        r102.putString("key", r100);     // Catch: Throwable -> L16
        r102.putString("value", r101);     // Catch: Throwable -> L16
        a(r102);     // Catch: Throwable -> L16
        goto L18
    L5:
        if (this.f32436e == false) goto L9;
        if (TextUtils.isEmpty(this.f32437f) == false) goto L14;
    L9:
        if (this.f32432a != null) goto L11;
        return this;
    L11:
        com.baidu.mshield.b.c.a.b("SPT putString:put by mBase");     // Catch: Throwable -> L16
        SharedPreferences.Editor r103 = this.f32432a;     // Catch: Throwable -> L16
        if (r103 == null) goto L18;
        r103.putString(r100, r101);     // Catch: Throwable -> L16
        goto L18
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String r100, Set<String> r101) {
        throw new RuntimeException("This editor not allow to call putStringSet.");
    }

    public b(Context r100, SharedPreferences.Editor r101, String r102, boolean r103, int r104, String r105) {
        this.f32433b = r100;
        this.f32432a = r101;
        this.f32434c = r104;
        this.f32435d = r102;
        this.f32436e = r103;
        this.f32437f = r105;
    }
}
