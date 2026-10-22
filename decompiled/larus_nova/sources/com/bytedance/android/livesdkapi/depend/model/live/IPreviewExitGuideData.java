package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\nR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\nR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0018\u0010\nR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001c\u0010\u001dR.\u0010&\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010 j\n\u0012\u0004\u0012\u00020!\u0018\u0001`\"8&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0006\u001a\u0004\b#\u0010$R\u001c\u0010)\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0006\u001a\u0004\b'\u0010\nR\u001c\u0010,\u001a\u0004\u0018\u00010\u00138&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0006\u001a\u0004\b*\u0010\u0015¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IPreviewExitGuideData;", "Lvh7/c;", "Lpy/k;", "getIcon", "()Lpy/k;", "getIcon$annotations", "()V", "icon", "", "getMainText", "()Ljava/lang/String;", "getMainText$annotations", n.KEY_MAIN_TEXT, "getSubText", "getSubText$annotations", n.KEY_SUB_TEXT, "getSchema", "getSchema$annotations", "schema", "", "getType", "()Ljava/lang/Integer;", "getType$annotations", "type", "getButtText", "getButtText$annotations", "buttText", "", "getLastLiveRecord", "()Ljava/lang/Long;", "getLastLiveRecord$annotations", "lastLiveRecord", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getUserList", "()Ljava/util/List;", "getUserList$annotations", "userList", "getTag", "getTag$annotations", "tag", "getLessFreq", "getLessFreq$annotations", "lessFreq", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface IPreviewExitGuideData extends c<IPreviewExitGuideData> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "button_text")
        public static /* synthetic */ void getButtText$annotations() {
        }

        @FieldName(name = "icon")
        public static /* synthetic */ void getIcon$annotations() {
        }

        @FieldName(name = "latest_live_record")
        public static /* synthetic */ void getLastLiveRecord$annotations() {
        }

        @FieldName(name = "less_freq")
        public static /* synthetic */ void getLessFreq$annotations() {
        }

        @FieldName(name = "main_text")
        public static /* synthetic */ void getMainText$annotations() {
        }

        @FieldName(name = a.KEY_SCHEMA_URL)
        public static /* synthetic */ void getSchema$annotations() {
        }

        @FieldName(name = "sub_text")
        public static /* synthetic */ void getSubText$annotations() {
        }

        @FieldName(name = "tag")
        public static /* synthetic */ void getTag$annotations() {
        }

        @FieldName(name = "type")
        public static /* synthetic */ void getType$annotations() {
        }

        @FieldName(name = "user_list")
        public static /* synthetic */ void getUserList$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "button_text")
    String getButtText();

    @FieldName(name = "icon")
    k getIcon();

    @FieldName(name = "latest_live_record")
    Long getLastLiveRecord();

    @FieldName(name = "less_freq")
    Integer getLessFreq();

    @FieldName(name = "main_text")
    String getMainText();

    @FieldName(name = a.KEY_SCHEMA_URL)
    String getSchema();

    @FieldName(name = "sub_text")
    String getSubText();

    @FieldName(name = "tag")
    String getTag();

    @FieldName(name = "type")
    Integer getType();

    @FieldName(name = "user_list")
    List<IBaseUser> getUserList();
}
