package com.obric.autogui;

import android.content.Context;
import com.obric.autogui.common.AutoOperateTask;
import com.obric.autogui.common.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.o;

/* JADX INFO: compiled from: LibAutoGUI.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f28925a = null;

    /* JADX INFO: compiled from: LibAutoGUI.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f28926a = null;

        static {
            f28926a = new a();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LibAutoGUI.kt */
    public static final class C0722b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f28927a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0722b.class) == true) goto L8;
            return false;
        L8:
            C0722b r6 = (C0722b) ZeusTransformUtils.preCheckCast(r5, C0722b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f28927a, r6.f28927a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f28927a.hashCode();
        }

        public String toString() {
            return "InitParams(context=" + this.f28927a + ')';
        }

        public C0722b(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r4, "context");
            this.f28927a = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
        }

        public final Context getContext() {
            return this.f28927a;
        }
    }

    static {
        f28925a = a.f28926a;
    }

    e a(C0722b r1);

    e a(String r1);

    Object a(AutoOperateTask r1, d<? super e> r2);
}
