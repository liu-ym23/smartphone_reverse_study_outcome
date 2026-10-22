package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000e\bg\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002%&R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001e\u0010\r\u001a\u00060\bj\u0002`\t8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0013\u001a\u00060\u000ej\u0002`\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\u00020\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0006\u001a\u0004\b\u001e\u0010\u001bR\u001a\u0010#\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0006\u001a\u0004\b!\u0010\u0016¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPKIconBubble;", "Lvh7/c;", "", "getBubbleType", "()I", "getBubbleType$annotations", "()V", "bubbleType", "Lcom/bytedance/android/live/base/model/message/a5;", "Lcom/bytedance/android/live/base/model/message/ITextKt;", "getDisplayTest", "()Lcom/bytedance/android/live/base/model/message/a5;", "getDisplayTest$annotations", "displayTest", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getDisplayIcon", "()Lpy/k;", "getDisplayIcon$annotations", "displayIcon", "", "getSchema", "()Ljava/lang/String;", "getSchema$annotations", "schema", "", "getShowTime", "()J", "getShowTime$annotations", "showTime", "getShowCount", "getShowCount$annotations", "showCount", "getActivityType", "getActivityType$annotations", "activityType", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "PKIconBubbleType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IPKIconBubble extends vh7.c<IPKIconBubble> {
    public static final a Companion = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPKIconBubble$PKIconBubbleType;", "", "PKIconBubbleTypeDefault", "PKIconBubbleTypeStarActivity", "PKIconBubbleTypeFateMatch", "PKIconBubbleTypeNewAnchor", "PKIconBubbleCommon", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum PKIconBubbleType extends Enum<PKIconBubbleType> {
        public static final PKIconBubbleType PKIconBubbleCommon = null;
        public static final PKIconBubbleType PKIconBubbleTypeDefault = null;
        public static final PKIconBubbleType PKIconBubbleTypeFateMatch = null;
        public static final PKIconBubbleType PKIconBubbleTypeNewAnchor = null;
        public static final PKIconBubbleType PKIconBubbleTypeStarActivity = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PKIconBubbleType[] f147055a = null;

        static {
            PKIconBubbleType r100 = new PKIconBubbleType("PKIconBubbleTypeDefault", 0);
            PKIconBubbleTypeDefault = r100;
            PKIconBubbleType r101 = new PKIconBubbleType("PKIconBubbleTypeStarActivity", 1);
            PKIconBubbleTypeStarActivity = r101;
            PKIconBubbleType r102 = new PKIconBubbleType("PKIconBubbleTypeFateMatch", 2);
            PKIconBubbleTypeFateMatch = r102;
            PKIconBubbleType r103 = new PKIconBubbleType("PKIconBubbleTypeNewAnchor", 3);
            PKIconBubbleTypeNewAnchor = r103;
            PKIconBubbleType r104 = new PKIconBubbleType("PKIconBubbleCommon", 4);
            PKIconBubbleCommon = r104;
            f147055a = new PKIconBubbleType[]{r100, r101, r102, r103, r104};
        }

        public static PKIconBubbleType valueOf(String r100) {
            return (PKIconBubbleType) r27.a.a(PKIconBubbleType.class, r100);
        }

        public static PKIconBubbleType[] values() {
            return (PKIconBubbleType[]) f147055a.clone();
        }

        public PKIconBubbleType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final com.bytedance.android.live.base.model.message.a5 f147056a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f147057b = null;

        public a() {
        }

        static {
            f147057b = new a();
            f147056a = (com.bytedance.android.live.base.model.message.a5) vh7.f.c(com.bytedance.android.live.base.model.message.a5.class);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f147057b;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "activity_name")
    String getActivityType();

    @FieldName(name = "bubble_type")
    int getBubbleType();

    @FieldName(name = "display_icon")
    py.k getDisplayIcon();

    @FieldName(name = "display_text")
    com.bytedance.android.live.base.model.message.a5 getDisplayTest();

    @FieldName(name = "schema")
    String getSchema();

    @FieldName(name = "show_count")
    long getShowCount();

    @FieldName(name = "show_time")
    long getShowTime();
}
