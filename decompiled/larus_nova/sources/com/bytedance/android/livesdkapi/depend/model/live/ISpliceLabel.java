package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0015\bg\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001'R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0017\u001a\u00020\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u001d\u001a\u00020\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001b\u0010\u0015R\u001a\u0010 \u001a\u00020\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0006\u001a\u0004\b\u001e\u0010\u0015R\u001a\u0010#\u001a\u00020\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0006\u001a\u0004\b!\u0010\u0015R\u001a\u0010&\u001a\u00020\u00138&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0006\u001a\u0004\b$\u0010\u0015¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ISpliceLabel;", "Lvh7/c;", "", "getText", "()Ljava/lang/String;", "getText$annotations", "()V", "text", "getTextColor", "getTextColor$annotations", "textColor", "Lpy/k;", "getBackground", "()Lpy/k;", "getBackground$annotations", "background", "getIcon", "getIcon$annotations", "icon", "", "getIconWidth", "()J", "getIconWidth$annotations", "iconWidth", "getIconHeight", "getIconHeight$annotations", "iconHeight", "getIconRadius", "getIconRadius$annotations", "iconRadius", "getTextSize", "getTextSize$annotations", "textSize", "getBold", "getBold$annotations", CommodityText.BOLD, "getItalic", "getItalic$annotations", "italic", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface ISpliceLabel extends c<ISpliceLabel> {
    public static final Companion Companion = null;
    public static final long DEFAULT_MODE = 0;
    public static final long NORMAL_MODE = 1;
    public static final long SPECIAL_MODE = 2;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ISpliceLabel$Companion;", "", "()V", "DEFAULT_MODE", "", "NORMAL_MODE", "SPECIAL_MODE", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final long DEFAULT_MODE = 0;
        public static final long NORMAL_MODE = 1;
        public static final long SPECIAL_MODE = 2;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "background_image")
        public static /* synthetic */ void getBackground$annotations() {
        }

        @FieldName(name = "text_front_bold")
        public static /* synthetic */ void getBold$annotations() {
        }

        @FieldName(name = "icon_image")
        public static /* synthetic */ void getIcon$annotations() {
        }

        @FieldName(name = "icon_height")
        public static /* synthetic */ void getIconHeight$annotations() {
        }

        @FieldName(name = "icon_raduis")
        public static /* synthetic */ void getIconRadius$annotations() {
        }

        @FieldName(name = "icon_width")
        public static /* synthetic */ void getIconWidth$annotations() {
        }

        @FieldName(name = "text_front_italic")
        public static /* synthetic */ void getItalic$annotations() {
        }

        @FieldName(name = "text")
        public static /* synthetic */ void getText$annotations() {
        }

        @FieldName(name = "text_color")
        public static /* synthetic */ void getTextColor$annotations() {
        }

        @FieldName(name = "text_front_size")
        public static /* synthetic */ void getTextSize$annotations() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "background_image")
    k getBackground();

    @FieldName(name = "text_front_bold")
    long getBold();

    @FieldName(name = "icon_image")
    k getIcon();

    @FieldName(name = "icon_height")
    long getIconHeight();

    @FieldName(name = "icon_raduis")
    long getIconRadius();

    @FieldName(name = "icon_width")
    long getIconWidth();

    @FieldName(name = "text_front_italic")
    long getItalic();

    @FieldName(name = "text")
    String getText();

    @FieldName(name = "text_color")
    String getTextColor();

    @FieldName(name = "text_front_size")
    long getTextSize();
}
