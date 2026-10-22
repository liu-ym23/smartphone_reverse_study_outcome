package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/widgets/PromotionListSearchButton;", "Landroid/widget/FrameLayout;", "", "showElevation", "", "setButtonElevation", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionListSearchButton extends FrameLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f149159b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CardView f149160a;

    public static final class a {
        public static String a(String r100, String r101, String r102, String r103, String r104, String r105, String r110) {
            Intrinsics.checkNotNullParameter(r100, "rawSchema");
            Uri.Builder r106 = UriProtector.parse(r100).buildUpon();
            r106.appendQueryParameter("enter_from_method", l0.i("enter_method"));
            r106.appendQueryParameter(ECFindSimilarConfig.ENTER_FROM_SECOND, l0.d());
            if (r105 != null) goto L21;
            r105 = null;
        L15:
            JSONObject r107 = new JSONObject();
            r107.put("live_room_author_id", r101);
            r107.put(MiniAppConstants.KEY_MINI_APP_LIVE_ROOM_ID, r102);
            r107.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r105);
            r107.put(ECFindSimilarConfig.HEIGHT_PERCENT, String.valueOf(73));
            Unit r108 = Unit.INSTANCE;
            r106.appendQueryParameter("common_search_params", r107.toString());
            JSONObject r109 = new JSONObject();
            JSONObject r111 = new JSONObject();
            Iterator<Map.Entry<String, String>> r112 = l0.g().entrySet().iterator();
        L17:
            if (r112.hasNext() == false) goto L19;
            Map.Entry<String, String> r113 = r112.next();
            r111.put(r113.getKey(), r113.getValue());
            goto L17
        L19:
            Unit r114 = Unit.INSTANCE;
            r109.put("general_params", r111.toString());
            r109.put("promotion_live_list_config", r110);
            r109.put("author_sell_score", r104);
            r109.put(com.bytedance.android.ec.core.event.a.KEY_LIVE_LIST_CHANNEL, r103);
            r106.appendQueryParameter("promotion_extra", r109.toString());
            return r106.build().toString();
        L21:
            JSONObject r115 = z1.g(Uri.decode(r105));     // Catch: Exception -> L12
            if (r115 == null) goto L15;
            r115.put(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, r115.optString("enter_from_merge"));     // Catch: Exception -> L12
            r115.put(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, r115.optString("enter_method"));     // Catch: Exception -> L12
            String r116 = r115.toString();     // Catch: Exception -> L12
            if (r116 == null) goto L15;
            String r117 = Uri.encode(r116);     // Catch: Exception -> L12
            if (r117 == null) goto L15;
            r105 = r117;
        L12:
            e = move-exception;
            ECExceptionMonitor.e(e);
            goto L15
        }
    }

    static {
    }

    public PromotionListSearchButton(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PromotionListSearchButton(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setButtonElevation(boolean r100) {
        CardView r101 = this.f149160a;
        if ((r101 instanceof CardView) == true) goto L5;
        r101 = null;
    L5:
        if (r101 == null) goto L11;
        if (r100 == false) goto L8;
        float r102 = UtilityKotlinExtentionsKt.c(15);
    L9:
        r101.setCardElevation(r102);
        return;
    L8:
        r102 = 0.0f;
        goto L9
    }

    public PromotionListSearchButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        CardView r103 = new CardView(getContext());
        View r104 = new View(getContext());
        r104.setBackgroundResource(R.drawable.shopping_ic_search_button);
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(UtilityKotlinExtentionsKt.d(16), UtilityKotlinExtentionsKt.d(16));
        r105.gravity = 16;
        r105.leftMargin = UtilityKotlinExtentionsKt.d(13);
        Unit r106 = Unit.INSTANCE;
        r104.setLayoutParams(r105);
        r103.addView(r104);
        this.f149160a = r103;
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(UtilityKotlinExtentionsKt.d(48), UtilityKotlinExtentionsKt.d(28));
        r107.gravity = GravityCompat.END;
        r107.topMargin = -UtilityKotlinExtentionsKt.d(1);
        r103.setLayoutParams(r107);
        r103.setBackgroundColor(th.a.a(r100, R.color.shopping_std_bg_primary_white));
        setBackgroundColor(0);
        addView(r103);
    }

    public /* synthetic */ PromotionListSearchButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
