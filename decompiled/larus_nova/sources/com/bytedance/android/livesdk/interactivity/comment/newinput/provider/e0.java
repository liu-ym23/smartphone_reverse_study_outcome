package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.r3;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e0 implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<c, z62.e> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f135865d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g f135866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f135867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f135868c;

    public static final class a implements z62.e {
        public a() {
        }

        @Override // z62.e
        public final void d(boolean r100) {
        }
    }

    public static final class b {
    }

    public final class c extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TextView f135869c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f135870d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ e0 f135871e;

        public final void g(boolean r100) {
            if (Intrinsics.areEqual(this.f135870d, Boolean.valueOf(r100)) == false) goto L5;
            return;
        L5:
            if (r100 == false) goto L13;
            TextView r101 = this.f135869c;
            if (r101 == null) goto L9;
            r101.setClickable(true);
        L9:
            TextView r102 = this.f135869c;
            if (r102 == null) goto L12;
            r102.setAlpha(1.0f);
        L12:
            r3.c(this.f135869c, com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_a11y_keyboard_send), true);
        L20:
            this.f135870d = Boolean.valueOf(r100);
            return;
        L13:
            TextView r103 = this.f135869c;
            if (r103 == null) goto L16;
            r103.setClickable(false);
        L16:
            TextView r104 = this.f135869c;
            if (r104 == null) goto L19;
            r104.setAlpha(0.34f);
        L19:
            r3.a(this.f135869c, com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_a11y_keyboard_send_disable));
            goto L20
        }

        public c(e0 r100, View r101, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r102) {
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "panelBridge");
            this.f135871e = r100;
            super(r101, r102);
        }
    }

    public static final class d implements z62.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e0 f135872a;

        public d(e0 r100) {
            this.f135872a = r100;
        }

        @Override // z62.e
        public final void d(boolean r100) {
            c r101 = this.f135872a.f135867b;
            if (r101 == null) goto L6;
            r101.g(r100);
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r100) {
    }

    static {
        f135865d = new a();
    }

    public e0() {
        this.f135868c = new d(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return InputSectionType.SEND_PORTRAIT;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return this.f135867b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r100) {
        Intrinsics.checkNotNullParameter(r100, "panelBridge");
        Activity r101 = r100.getActivity();
        Editable r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        this.f135866a = r100;
        View r103 = LayoutInflater.from(r101).inflate(R.layout.ttlive_view_input_send_portrait, null);
        c r104 = new c(this, r103, r100);
        TextView r105 = (TextView) r104.f135512a.findViewById(R.id.tv_send_portrait);
        r104.f135869c = r105;
        if (r105 == null) goto L8;
        r105.setOnClickListener(new f0(r104));
    L8:
        r3.a(r104.f135869c, com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_a11y_keyboard_send));
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r106 = r104.f135871e.f135866a;
        if (r106 == null) goto L13;
        EditText r107 = r106.f135496a;
        if (r107 == null) goto L13;
        r102 = r107.getText();
    L13:
        r104.g(!TextUtils.isEmpty(r102));
        Unit r108 = Unit.INSTANCE;
        this.f135867b = r104;
        return r103;
    }
}
