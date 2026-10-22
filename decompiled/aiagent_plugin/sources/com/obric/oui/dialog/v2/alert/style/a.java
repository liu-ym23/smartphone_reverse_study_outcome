package com.obric.oui.dialog.v2.alert.style;

import android.content.DialogInterface;
import android.view.View;
import com.obric.oui.dialog.base.AbstractDialog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: ButtonStyleController.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0952a f35139a = null;

    /* JADX INFO: renamed from: com.obric.oui.dialog.v2.alert.style.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ButtonStyleController.kt */
    public static final class C0952a {
        public /* synthetic */ C0952a(h r1) {
            this();
        }

        private C0952a() {
        }
    }

    /* JADX INFO: compiled from: ButtonStyleController.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f35140a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f35141b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f35142c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ b[] f35143d = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f35140a, f35141b, f35142c};
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f35143d.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f35140a = new b("TextReverse", 0);
            f35141b = new b("TextReverse2", 1);
            f35142c = new b("Negative", 2);
            f35143d = a();
        }
    }

    static {
        f35139a = new C0952a(null);
    }

    public abstract View a();

    public abstract void a(View r1);

    public abstract void a(CharSequence r1, DialogInterface.OnClickListener r2, b r3);

    public abstract void a(CharSequence r1, DialogInterface.OnClickListener r2, b r3, boolean r4);

    public abstract View b();

    public abstract void b(CharSequence r1, DialogInterface.OnClickListener r2, b r3);

    public abstract View c();

    public a() {
    }

    @Override // com.obric.oui.dialog.v2.alert.style.e
    public void a(AbstractDialog r3) {
        e.a.a((e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin"), r3);
    }

    @Override // com.obric.oui.dialog.v2.alert.style.e
    public void a(AlertDialogHost r3) {
        AlertDialogHost r4 = (AlertDialogHost) ZeusTransformUtils.wrapperContextForParams(r3, AlertDialogHost.class, "com.obric.aiagent.plugin");
        e.a.a((e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin"), r4);
    }
}
