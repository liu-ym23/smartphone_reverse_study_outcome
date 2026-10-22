package com.bytedance.android.livesdk.interactivity.interactive;

import com.bytedance.android.livesdk.chatroom.ui.u9;
import com.google.gson.annotations.SerializedName;
import com.larus.avatar.impl.scan.view.ScanCameraBeautyLevel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001:\u0003\u0019\u001a\u001bB\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/a;", "", "", "switchOn", "Z", "getSwitchOn", "()Z", "setSwitchOn", "(Z)V", "Lcom/bytedance/android/livesdk/interactivity/interactive/a$b;", ScanCameraBeautyLevel.CATEGORY_KEY_BASIC, "Lcom/bytedance/android/livesdk/interactivity/interactive/a$b;", "getBasic", "()Lcom/bytedance/android/livesdk/interactivity/interactive/a$b;", "setBasic", "(Lcom/bytedance/android/livesdk/interactivity/interactive/a$b;)V", "Lcom/bytedance/android/livesdk/interactivity/interactive/a$a;", "background", "Lcom/bytedance/android/livesdk/interactivity/interactive/a$a;", "getBackground", "()Lcom/bytedance/android/livesdk/interactivity/interactive/a$a;", "setBackground", "(Lcom/bytedance/android/livesdk/interactivity/interactive/a$a;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
final class a {

    @SerializedName("background")
    private C2176a background;

    /* JADX INFO: renamed from: basic, reason: collision with root package name */
    @SerializedName(ScanCameraBeautyLevel.CATEGORY_KEY_BASIC)
    private b f137159basic;

    @SerializedName("switch_on")
    private boolean switchOn;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.interactive.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/a$a;", "", "", "titleColor", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setTitleColor", "(Ljava/lang/String;)V", "inputPanelColor", "b", "setInputPanelColor", "inputPanel", "getInputPanel", "setInputPanel", "inputBoxColor", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setInputBoxColor", "textColor", "d", "setTextColor", "inputPanelTopColor", "c", "setInputPanelTopColor", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C2176a {

        @SerializedName("input_box_color")
        private String inputBoxColor;

        @SerializedName("input_panel")
        private String inputPanel;

        @SerializedName("input_panel_color")
        private String inputPanelColor;

        @SerializedName("comment_panel")
        private String inputPanelTopColor;

        @SerializedName("comment_panel_text_color")
        private String textColor;

        @SerializedName("title_color")
        private String titleColor;

        public C2176a() {
        }

        public final String a() {
            return this.inputBoxColor;
        }

        public final String b() {
            return this.inputPanelColor;
        }

        public final String c() {
            return this.inputPanelTopColor;
        }

        public final String d() {
            return this.textColor;
        }

        public final String e() {
            return this.titleColor;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/a$b;", "", "", "titleType", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setTitleType", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdk/interactivity/interactive/a$c;", "title", "Lcom/bytedance/android/livesdk/interactivity/interactive/a$c;", "b", "()Lcom/bytedance/android/livesdk/interactivity/interactive/a$c;", com.alipay.sdk.m.x.d.f25925o, "(Lcom/bytedance/android/livesdk/interactivity/interactive/a$c;)V", "inputText", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setInputText", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("input_text")
        private String inputText;

        @SerializedName("title")
        private c title;

        @SerializedName("title_type")
        private String titleType;

        public b() {
        }

        public final String a() {
            return this.inputText;
        }

        public final c b() {
            return this.title;
        }

        public final String c() {
            return this.titleType;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/a$c;", "", "", "text", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "image", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setImage", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("image")
        private String image;

        @SerializedName("text")
        private String text;

        public c() {
        }

        public final String a() {
            return this.image;
        }

        public final String b() {
            return this.text;
        }
    }

    public a() {
    }

    public final u9 a() {
        b r100 = this.f137159basic;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.c();
    L7:
        if (Intrinsics.areEqual(r102, "image") == false) goto L9;
        int r103 = 2;
    L10:
        b r104 = this.f137159basic;
        if (r104 == null) goto L13;
        String r105 = r104.a();
    L14:
        b r106 = this.f137159basic;
        if (r106 == null) goto L19;
        c r107 = r106.b();
        if (r107 == null) goto L19;
        String r108 = r107.b();
    L20:
        b r109 = this.f137159basic;
        if (r109 == null) goto L25;
        c r110 = r109.b();
        if (r110 == null) goto L25;
        String r111 = r110.a();
    L26:
        C2176a r112 = this.background;
        if (r112 == null) goto L29;
        String r113 = r112.e();
    L30:
        u9.a r114 = new u9.a(r103, r108, r111, r113);
        C2176a r115 = this.background;
        if (r115 == null) goto L33;
        String r116 = r115.b();
    L34:
        C2176a r117 = this.background;
        if (r117 == null) goto L37;
        String r118 = r117.a();
    L38:
        C2176a r119 = this.background;
        if (r119 == null) goto L41;
        String r120 = r119.d();
    L42:
        C2176a r121 = this.background;
        if (r121 == null) goto L46;
        r101 = r121.c();
    L46:
        return new u9(r105, r114, r116, r118, r120, r101);
    L41:
        r120 = null;
        goto L42
    L37:
        r118 = null;
        goto L38
    L33:
        r116 = null;
        goto L34
    L29:
        r113 = null;
    L25:
        r111 = null;
    L19:
        r108 = null;
        goto L20
    L13:
        r105 = null;
        goto L14
    L9:
        r103 = 1;
        goto L10
    L5:
        r102 = null;
        goto L7
    }
}
