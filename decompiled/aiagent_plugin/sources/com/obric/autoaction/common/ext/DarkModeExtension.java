package com.obric.autoaction.common.ext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.p;
import com.obric.autoaction.common.base.ActivityExtension;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: DarkModeExtension.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DarkModeExtension extends ActivityExtension<com.obric.autoaction.common.ext.a> {
    private static final String TAG = "DarkModeExtension";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24635a = null;

    /* JADX INFO: compiled from: DarkModeExtension.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f24635a = new a(null);
    }

    public DarkModeExtension(com.obric.autoaction.common.ext.a r3, AppCompatActivity r4) {
        AppCompatActivity r5 = (AppCompatActivity) ZeusTransformUtils.wrapperContextForParams(r4, AppCompatActivity.class, "com.obric.aiagent.plugin");
        o.e(r3, "config");
        o.e(r5, "host");
        super((com.obric.autoaction.common.base.b) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.common.base.b.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // androidx.lifecycle.d
    public void b(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        o.e(r4, "owner");
        super.b(r4);
    }
}
