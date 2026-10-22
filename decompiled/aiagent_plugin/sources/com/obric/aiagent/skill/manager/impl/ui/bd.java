package com.obric.aiagent.skill.manager.impl.ui;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFormSheetController.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class bd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20630a = null;
    private static final bd f = null;
    private static final bd g = null;
    private static final bd h = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f20631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f20632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f20633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f20634e;

    /* JADX INFO: compiled from: SkillFormSheetController.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final bd a() {
            return bd.e();
        }

        public final bd b() {
            return bd.f();
        }

        public final bd c() {
            return bd.g();
        }
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, bd.class) == true) goto L8;
        return false;
    L8:
        bd r6 = (bd) ZeusTransformUtils.preCheckCast(r5, bd.class, "com.obric.aiagent.plugin");
        if (this.f20631b == r6.f20631b) goto L12;
        return false;
    L12:
        if (this.f20632c == r6.f20632c) goto L15;
        return false;
    L15:
        if (this.f20633d == r6.f20633d) goto L18;
        return false;
    L18:
        if (this.f20634e == r6.f20634e) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.f20631b) * 31) + Integer.hashCode(this.f20632c)) * 31) + Integer.hashCode(this.f20633d)) * 31) + Integer.hashCode(this.f20634e);
    }

    public String toString() {
        return "SkillFormTextConfig(nameHint=" + this.f20631b + ", descriptionLabel=" + this.f20632c + ", descriptionHint=" + this.f20633d + ", bodyHint=" + this.f20634e + ')';
    }

    public bd(int r1, int r2, int r3, int r4) {
        this.f20631b = r1;
        this.f20632c = r2;
        this.f20633d = r3;
        this.f20634e = r4;
    }

    public static final /* synthetic */ bd e() {
        return f;
    }

    public static final /* synthetic */ bd f() {
        return g;
    }

    public static final /* synthetic */ bd g() {
        return h;
    }

    public final int a() {
        return this.f20631b;
    }

    public final int b() {
        return this.f20632c;
    }

    public final int c() {
        return this.f20633d;
    }

    public final int d() {
        return this.f20634e;
    }

    static {
        f20630a = new a(null);
        bd r0 = new bd(ZeusTransformUtils.mapRes(R.string.obric_skill_form_name_hint, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_form_name_hint"), ZeusTransformUtils.mapRes(R.string.obric_skill_form_description_label, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_form_description_label"), ZeusTransformUtils.mapRes(R.string.obric_skill_form_description_hint, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_form_description_hint"), ZeusTransformUtils.mapRes(R.string.obric_skill_form_body_hint, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_form_body_hint"));
        f = r0;
        g = r0;
        h = new bd(ZeusTransformUtils.mapRes(R.string.obric_skill_form_edit_name_hint, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_form_edit_name_hint"), ZeusTransformUtils.mapRes(R.string.obric_skill_form_description_label, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_form_description_label"), ZeusTransformUtils.mapRes(R.string.obric_skill_form_edit_description_hint, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_form_edit_description_hint"), ZeusTransformUtils.mapRes(R.string.obric_skill_form_edit_body_hint, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_form_edit_body_hint"));
    }
}
