package com.google.android.material.button;

import android.content.Context;
import androidx.activity.result.ActivityResult;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import com.stepos.aiengine.modelmanager.settings.PrivacySettingsFragment;
import y1.c;
import y4.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements g.d, c.InterfaceC0177c, d.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f4761g;

    public /* synthetic */ a(Object obj) {
        this.f4761g = obj;
    }

    @Override // d.a
    public void a(Object obj) {
        PrivacySettingsFragment.withdrawLauncher$lambda$0((PrivacySettingsFragment) this.f4761g, (ActivityResult) obj);
    }

    @Override // y1.c.InterfaceC0177c
    public y1.c b(c.b bVar) {
        Context context = (Context) this.f4761g;
        String str = bVar.f13969b;
        c.a callback = bVar.f13970c;
        kotlin.jvm.internal.g.f(callback, "callback");
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
        }
        return new FrameworkSQLiteOpenHelper(context, str, callback, true, true);
    }
}
