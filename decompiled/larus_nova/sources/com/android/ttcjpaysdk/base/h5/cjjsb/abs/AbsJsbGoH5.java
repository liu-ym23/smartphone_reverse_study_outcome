package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.NothingOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbGoH5;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbGoH5$GoH5Input;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/NothingOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "GoH5Input", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbGoH5 extends AbsJSBMethod<GoH5Input, NothingOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003¢\u0006\u0002\u0010\u0012R\u0012\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbGoH5$GoH5Input;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "title", "", "url", "hide_status_bar", "background_color", "status_bar_text_style", "back_button_color", "back_button_icon", "title_text_color", "title_bar_bg_color", "hide_title_bar", "canvas_mode", "show_loading", "", "enable_font_scale", "is_caijing_saas", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class GoH5Input implements IJSBParams {
        public String back_button_color;
        public String back_button_icon;
        public String background_color;
        public String canvas_mode;
        public String enable_font_scale;
        public String hide_status_bar;
        public String hide_title_bar;
        public String is_caijing_saas;
        public int show_loading;
        public String status_bar_text_style;
        public String title;
        public String title_bar_bg_color;
        public String title_text_color;
        public String url;

        public GoH5Input() {
            this(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, 16383, null);
        }

        public GoH5Input(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, String r112, int r113, String r114, String r115) {
            Intrinsics.checkNotNullParameter(r100, "title");
            Intrinsics.checkNotNullParameter(r101, "url");
            Intrinsics.checkNotNullParameter(r102, "hide_status_bar");
            Intrinsics.checkNotNullParameter(r103, "background_color");
            Intrinsics.checkNotNullParameter(r104, "status_bar_text_style");
            Intrinsics.checkNotNullParameter(r105, "back_button_color");
            Intrinsics.checkNotNullParameter(r106, "back_button_icon");
            Intrinsics.checkNotNullParameter(r107, "title_text_color");
            Intrinsics.checkNotNullParameter(r110, "title_bar_bg_color");
            Intrinsics.checkNotNullParameter(r111, "hide_title_bar");
            Intrinsics.checkNotNullParameter(r112, "canvas_mode");
            Intrinsics.checkNotNullParameter(r114, "enable_font_scale");
            Intrinsics.checkNotNullParameter(r115, "is_caijing_saas");
            this.title = r100;
            this.url = r101;
            this.hide_status_bar = r102;
            this.background_color = r103;
            this.status_bar_text_style = r104;
            this.back_button_color = r105;
            this.back_button_icon = r106;
            this.title_text_color = r107;
            this.title_bar_bg_color = r110;
            this.hide_title_bar = r111;
            this.canvas_mode = r112;
            this.show_loading = r113;
            this.enable_font_scale = r114;
            this.is_caijing_saas = r115;
        }

        public /* synthetic */ GoH5Input(String r110, String r111, String r112, String r113, String r210, String r211, String r212, String r213, String r214, String r215, String r216, int r217, String r218, String r219, int r310, DefaultConstructorMarker r311) {
            String r100 = "";
            if ((r310 & 1) == 0) goto L5;
            String r101 = "";
        L7:
            if ((r310 & 2) == 0) goto L9;
            String r102 = "";
        L11:
            if ((r310 & 4) == 0) goto L13;
            String r103 = "";
        L15:
            if ((r310 & 8) == 0) goto L17;
            String r104 = "";
        L19:
            if ((r310 & 16) == 0) goto L21;
            String r105 = "";
        L23:
            if ((r310 & 32) == 0) goto L25;
            String r106 = "";
        L27:
            if ((r310 & 64) == 0) goto L29;
            String r107 = "";
        L31:
            if ((r310 & 128) == 0) goto L33;
            String r108 = "";
        L35:
            if ((r310 & 256) == 0) goto L37;
            String r114 = "";
        L39:
            if ((r310 & 512) == 0) goto L41;
            String r115 = "";
        L43:
            if ((r310 & 1024) == 0) goto L45;
            String r116 = "";
        L47:
            if ((r310 & 2048) == 0) goto L49;
            int r117 = 0;
        L51:
            if ((r310 & 4096) == 0) goto L53;
            String r118 = "";
        L55:
            if ((r310 & 8192) != 0) goto L58;
            r100 = r219;
        L58:
            this(r101, r102, r103, r104, r105, r106, r107, r108, r114, r115, r116, r117, r118, r100);
            return;
        L53:
            r118 = r218;
            goto L55
        L49:
            r117 = r217;
            goto L51
        L45:
            r116 = r216;
            goto L47
        L41:
            r115 = r215;
            goto L43
        L37:
            r114 = r214;
            goto L39
        L33:
            r108 = r213;
            goto L35
        L29:
            r107 = r212;
            goto L31
        L25:
            r106 = r211;
            goto L27
        L21:
            r105 = r210;
            goto L23
        L17:
            r104 = r113;
            goto L19
        L13:
            r103 = r112;
            goto L15
        L9:
            r102 = r111;
            goto L11
        L5:
            r101 = r110;
            goto L7
        }
    }

    public AbsJsbGoH5() {
        this.name = "ttcjpay.goH5";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
