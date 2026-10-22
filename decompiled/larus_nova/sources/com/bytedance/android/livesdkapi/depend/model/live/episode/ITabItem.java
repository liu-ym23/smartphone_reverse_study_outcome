package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\nR\u001a\u0010\u0012\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\u0004R\u001a\u0010\u0017\u001a\u00020\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001f\u001a\u00020\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001d\u0010\u0015R\u001a\u0010\"\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0006\u001a\u0004\b \u0010\n¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ITabItem;", "Lvh7/c;", "", "getTabType", "()J", "getTabType$annotations", "()V", "tabType", "", "getTabName", "()Ljava/lang/String;", "getTabName$annotations", "tabName", "getSchema", "getSchema$annotations", "schema", "getTabId", "getTabId$annotations", "tabId", "", "getShowType", "()I", "getShowType$annotations", "showType", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IBubble;", "getBubble", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IBubble;", "getBubble$annotations", "bubble", "getDisablePreload", "getDisablePreload$annotations", "disablePreload", "getColor", "getColor$annotations", "color", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ITabItem extends c<ITabItem> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "bubble")
        public static /* synthetic */ void getBubble$annotations() {
        }

        @FieldName(name = "color")
        public static /* synthetic */ void getColor$annotations() {
        }

        @FieldName(name = "disable_preload")
        public static /* synthetic */ void getDisablePreload$annotations() {
        }

        @FieldName(name = "jump_link")
        public static /* synthetic */ void getSchema$annotations() {
        }

        @FieldName(name = "tab_show_type")
        public static /* synthetic */ void getShowType$annotations() {
        }

        @FieldName(name = "tab_id")
        public static /* synthetic */ void getTabId$annotations() {
        }

        @FieldName(name = a.KEY_TAB_NAME)
        public static /* synthetic */ void getTabName$annotations() {
        }

        @FieldName(name = "tab_type")
        public static /* synthetic */ void getTabType$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "bubble")
    IBubble getBubble();

    @FieldName(name = "color")
    String getColor();

    @FieldName(name = "disable_preload")
    int getDisablePreload();

    @FieldName(name = "jump_link")
    String getSchema();

    @FieldName(name = "tab_show_type")
    int getShowType();

    @FieldName(name = "tab_id")
    long getTabId();

    @FieldName(name = a.KEY_TAB_NAME)
    String getTabName();

    @FieldName(name = "tab_type")
    long getTabType();
}
