package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class q implements k82.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CheckBox f137322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VSInputSectionType f137323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k82.a f137324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k82.c f137325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f137326e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f137327f;

    public static final class a {
    }

    public final class b extends k82.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ q f137328c;

        public b(q r100, View r101, h82.b r102) {
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "panelBridge");
            this.f137328c = r100;
            super(r101, r102);
        }
    }

    public static final class c implements j82.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f137329a;

        @Override // j82.d
        public final boolean m() {
            CheckBox r100 = this.f137329a.f137322a;
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.isChecked();
        }

        public c(q r100) {
            this.f137329a = r100;
        }
    }

    static {
    }

    @Override // k82.d
    public final void a() {
    }

    @Override // k82.d
    public final void d() {
    }

    @Override // k82.d
    public final void e() {
    }

    @Override // k82.d
    public final VSInputSectionType b() {
        return this.f137323b;
    }

    @Override // k82.d
    public final k82.c c() {
        return this.f137325d;
    }

    public final Context getContext() {
        return this.f137327f;
    }

    public q(Context r100) {
        this.f137327f = r100;
        this.f137323b = VSInputSectionType.PUBLISH;
        this.f137326e = new c(this);
    }

    @Override // k82.d
    public final View g(h82.b r100) {
        Intrinsics.checkNotNullParameter(r100, "panelBridge");
        Activity r101 = r100.getActivity();
        if (r101 != null) goto L5;
        return null;
    L5:
        this.f137324c = r100;
        View r102 = LayoutInflater.from(r101).inflate(R.layout.ttlive_view_input_publish_to_story, null);
        b r103 = new b(this, r102, r100);
        q r104 = r103.f137328c;
        r104.f137322a = (CheckBox) r103.f502090a.findViewById(R.id.publish_as_story_checkbox);
        q r105 = r103.f137328c;
        CheckBox r106 = r105.f137322a;
        if (r106 == null) goto L14;
        k82.a r107 = r105.f137324c;
        if (r107 == null) goto L12;
        t9 r108 = r107.s();
        if (r108 == null) goto L12;
        boolean r109 = r108.f114233q;
    L13:
        r106.setChecked(r109);
        r106.setOnCheckedChangeListener(new r(r103));
    L12:
        r109 = false;
    L14:
        Unit r110 = Unit.INSTANCE;
        this.f137325d = r103;
        return r102;
    }

    @Override // k82.d
    public final void h(VSInputSectionType r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "sectionType");
        Intrinsics.checkNotNullParameter(r101, "view");
        k82.d.a.a(r100, r101);
    }
}
