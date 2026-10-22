package com.bytedance.android.shopping.api;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.model.k;
import com.bytedance.android.ec.model.order.ECOrderTrackerData;
import com.bytedance.android.ec.model.order.ProductDetailPageParams;
import com.bytedance.android.ec.model.order.ProductPurchaseInfo;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.utils.s;
import com.bytedance.android.shopping.api.mall.mallSession.IMallSessionService;
import com.bytedance.android.shopping.feed.model.InflowFeedPageParams;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import n83.f;
import n83.h;
import n83.i;
import org.json.JSONObject;
import p83.c;
import p83.e;
import sc3.a;
import sc3.g;
import sc3.j;
import tf3.d;
import vl.b;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0096\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&Jj\u0010\u0015\u001a\u00020\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n26\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\rH&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH&J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH&J\n\u0010!\u001a\u0004\u0018\u00010 H&J\n\u0010#\u001a\u0004\u0018\u00010\"H&J\b\u0010$\u001a\u00020\u0013H&J\n\u0010&\u001a\u0004\u0018\u00010%H&J\n\u0010(\u001a\u0004\u0018\u00010'H&J\n\u0010*\u001a\u0004\u0018\u00010)H&Jh\u00103\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010\u000b2\b\u0010-\u001a\u0004\u0018\u00010\u000b2\b\u0010.\u001a\u0004\u0018\u00010\u000b2\b\u0010/\u001a\u0004\u0018\u00010\u000b2\b\u00100\u001a\u0004\u0018\u00010\u000b2\b\u00101\u001a\u0004\u0018\u00010\u000b2\u001a\u00102\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0013\u0018\u00010\rH&J*\u00109\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u000b2\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u0002052\b\u00108\u001a\u0004\u0018\u00010\u000bH&J\b\u0010:\u001a\u00020\u0013H&J\u001a\u0010?\u001a\u00020\u00132\b\u0010<\u001a\u0004\u0018\u00010;2\u0006\u0010>\u001a\u00020=H&J\n\u0010A\u001a\u0004\u0018\u00010@H&J\b\u0010B\u001a\u00020\u0013H&J\n\u0010D\u001a\u0004\u0018\u00010CH&J \u0010I\u001a\u0004\u0018\u00010H2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010G\u001a\b\u0012\u0004\u0012\u00020F0EH&J6\u0010M\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0016\u0010J\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\n2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010KH&J\u0012\u0010O\u001a\u00020\u000e2\b\u0010N\u001a\u0004\u0018\u00010\u000bH&J\u001a\u0010R\u001a\u00020\u00132\b\u0010P\u001a\u0004\u0018\u00010\u000b2\u0006\u0010Q\u001a\u00020\u000eH&J^\u0010a\u001a\u00020\u00132\u0006\u0010<\u001a\u00020S2\u0006\u0010U\u001a\u00020T2\u0006\u0010W\u001a\u00020V2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010X2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010Z2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\\2\u0018\b\u0002\u0010`\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010_\u0012\u0004\u0012\u00020\u0013\u0018\u00010^H&J\u001c\u0010b\u001a\u00020\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u00100\u001a\u0004\u0018\u00010\u000bH&J\b\u0010c\u001a\u00020\u0013H&J\n\u0010d\u001a\u0004\u0018\u00010\u000bH&J\n\u0010e\u001a\u0004\u0018\u00010\u000bH&JI\u0010k\u001a\u00020\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010f\u001a\u00020\u000b2#\u0010h\u001a\u001f\u0012\u0013\u0012\u00110g¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0013\u0018\u00010^2\b\u0010j\u001a\u0004\u0018\u00010iH&J4\u0010r\u001a\u00020\u00132\u0006\u0010l\u001a\u0002052\u0006\u0010m\u001a\u00020H2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020n0E2\f\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00130pH&J\u001a\u0010s\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u00104\u001a\u00020\u000bH&J\n\u0010u\u001a\u0004\u0018\u00010tH&J\u000e\u0010w\u001a\b\u0012\u0002\b\u0003\u0018\u00010vH&J\u000e\u0010x\u001a\b\u0012\u0002\b\u0003\u0018\u00010vH&J&\u0010{\u001a\b\u0012\u0002\b\u0003\u0018\u00010v2\u0006\u0010y\u001a\u00020\u000b2\u0006\u0010z\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000bH&JN\u0010{\u001a\b\u0012\u0002\b\u0003\u0018\u00010v2\u0006\u0010y\u001a\u00020\u000b2\u0006\u0010z\u001a\u00020\u000b2\u0012\u0010|\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010,\u001a\u00020\u000b2\b\b\u0002\u0010}\u001a\u00020\u000e2\b\b\u0002\u0010~\u001a\u00020\u000eH&J$\u0010\u007f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010E2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010,\u001a\u0004\u0018\u00010\u000bH&J/\u0010\u007f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010E2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010,\u001a\u0004\u0018\u00010\u000b2\t\b\u0002\u0010\u0080\u0001\u001a\u00020\u000eH&J\u001d\u0010\u0083\u0001\u001a\u00020\u000e2\u0007\u0010\u0081\u0001\u001a\u00020\u000b2\t\b\u0002\u0010\u0082\u0001\u001a\u00020\u000eH&J\u001b\u0010\u0085\u0001\u001a\u00020\u000b2\u0007\u0010\u0081\u0001\u001a\u00020\u000b2\u0007\u0010\u0084\u0001\u001a\u00020gH&J=\u0010\u0088\u0001\u001a$\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0086\u0001j\u0011\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u0087\u00012\u0007\u0010\u0081\u0001\u001a\u00020\u000b2\u0007\u0010\u0084\u0001\u001a\u00020gH&J\u0015\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008a\u00012\u0007\u0010\u0089\u0001\u001a\u00020\u000bH&J&\u0010\u008f\u0001\u001a\u00020\u00132\u0007\u0010\u008c\u0001\u001a\u00020\u000e2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u000b2\u0007\u0010\u008e\u0001\u001a\u00020\u000bH&J\u0014\u0010\u0090\u0001\u001a\u00020\u00132\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\u0092\u0001\u001a\u00020\u000b2\u0007\u0010\u0091\u0001\u001a\u00020\u000bH&J+\u0010\u0095\u0001\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00062\u000f\b\u0001\u0010\u0093\u0001\u001a\b\u0012\u0004\u0012\u0002050E2\u0007\u0010\u0094\u0001\u001a\u00020\u000eH&J0\u0010\u0099\u0001\u001a\u0004\u0018\u00010H2\u0006\u0010\u0007\u001a\u00020\u00062\u0007\u0010\u0096\u0001\u001a\u0002052\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010i2\u0007\u0010\u0098\u0001\u001a\u00020\u000eH&J\u000b\u0010\u009a\u0001\u001a\u0004\u0018\u00010tH&J\u0017\u0010\u009b\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nH&J\u0098\u0001\u0010¨\u0001\u001a\u00020\u00132\b\u0010\u009d\u0001\u001a\u00030\u009c\u00012\n\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009e\u00012\u0006\u0010\u0007\u001a\u00020\u00062\f\b\u0002\u0010¡\u0001\u001a\u0005\u0018\u00010 \u00012\u000b\b\u0002\u0010¢\u0001\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u000b2\u000b\b\u0002\u0010£\u0001\u001a\u0004\u0018\u00010\u000b2\u000b\b\u0002\u0010¤\u0001\u001a\u0004\u0018\u00010\u000e2\u000b\b\u0002\u0010¥\u0001\u001a\u0004\u0018\u00010\u000b2\f\b\u0002\u0010§\u0001\u001a\u0005\u0018\u00010¦\u0001H&¢\u0006\u0006\b¨\u0001\u0010©\u0001J\u001b\u0010¬\u0001\u001a\u00020\u00132\u0006\u0010<\u001a\u00020;2\b\u0010«\u0001\u001a\u00030ª\u0001H&JÄ\u0001\u0010º\u0001\u001a\u00020\u00132\b\u0010¡\u0001\u001a\u00030 \u00012\n\u0010®\u0001\u001a\u0005\u0018\u00010\u00ad\u00012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010X2\u0007\u0010¯\u0001\u001a\u00020\u000e2\u0007\u0010°\u0001\u001a\u00020\u000e2\n\u0010±\u0001\u001a\u0005\u0018\u00010\u009c\u00012\u000b\b\u0002\u0010²\u0001\u001a\u0004\u0018\u00010\u000b2\f\b\u0002\u0010§\u0001\u001a\u0005\u0018\u00010¦\u00012\f\b\u0002\u0010´\u0001\u001a\u0005\u0018\u00010³\u00012\f\b\u0002\u0010¶\u0001\u001a\u0005\u0018\u00010µ\u00012\f\b\u0002\u0010¸\u0001\u001a\u0005\u0018\u00010·\u00012\u001a\b\u0002\u0010¹\u0001\u001a\u0013\u0012\u0007\u0012\u0005\u0018\u00010·\u0001\u0012\u0004\u0012\u00020\u0013\u0018\u00010^2\u0018\b\u0002\u0010`\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010_\u0012\u0004\u0012\u00020\u0013\u0018\u00010^H&J)\u0010¿\u0001\u001a\u0005\u0018\u00010¾\u00012\b\u0010»\u0001\u001a\u00030\u00ad\u00012\b\u0010¼\u0001\u001a\u00030\u009c\u00012\u0007\u0010½\u0001\u001a\u00020HH&J\u001f\u0010À\u0001\u001a\u00020\u000b2\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\t\u0010Á\u0001\u001a\u00020\u000eH&J/\u0010Ä\u0001\u001a\u00020\u00132$\u0010Ã\u0001\u001a\u001f\u0012\u0006\u0012\u0004\u0018\u00010g\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00130Â\u0001H&J\u001e\u0010Å\u0001\u001a\u00020\u00132\u0013\u0010Ã\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00130^H&J\u001e\u0010Æ\u0001\u001a\u00020\u00132\u0013\u0010Ã\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00130^H&J\t\u0010Ç\u0001\u001a\u00020\u0013H&J\u001d\u0010Ê\u0001\u001a\u0005\u0018\u00010É\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0007\u0010È\u0001\u001a\u000205H&J\f\u0010Ì\u0001\u001a\u0005\u0018\u00010Ë\u0001H&J\u0017\u0010Î\u0001\u001a\u0005\u0018\u00010Í\u00012\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u000bH&J\f\u0010Ð\u0001\u001a\u0005\u0018\u00010Ï\u0001H&¨\u0006Ñ\u0001"}, d2 = {"Lcom/bytedance/android/shopping/api/IEShoppingService;", "", "Ln83/i;", "getECVisualSearchService", "Ln83/g;", "getECBoughtService", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "promotionSource", "", "", "params", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "confirm", "firstTime", "", "callback", "checkLawHint", "Lsc3/c;", "getBuyNowService", "Lsc3/e;", "getCartService", "Lsc3/d;", "getCardKitService", "Lsc3/g;", "getCollectService", "Lsc3/h;", "getOrderListService", "Lsc3/i;", "getSkuYataService", "Lsc3/j;", "getYataService", "agreeXiaoDianLaw", "Lp83/d;", "getAnchorV3Service", "Lp83/c;", "getAnchorInnerService", "Lp83/e;", "getAnchorV3StoreService", "fromAct", "url", "commodityId", "commodityType", "groupId", "authorId", "previousPage", "nextPage", "openTaobao", "result", "", "pageFrom", "qrType", "scanFrom", "onGetQrScanResult", "stopShowFloatInNextLifecycle", "Landroid/app/Activity;", "activity", "Ln83/c;", "extra", "startShowFloatInNextLifecycle", "Ln83/a;", "getAppLifecycleObserver", "clearRoomLifecycleData", "Ln83/k;", "getMonitorService", "", "Ltf3/d;", "coupons", "Landroid/view/View;", "createCouponView", "initData", "Landroid/widget/FrameLayout;", "viewGroup", "showTaskBanner", "containerId", "hideTaskBanner", "id", "show", "switchBannerVisible", "Landroidx/fragment/app/FragmentActivity;", "Lcom/bytedance/android/ec/model/order/ECOrderTrackerData;", "trackerData", "Lcom/bytedance/android/ec/model/order/ProductPurchaseInfo;", "purchaseInfo", "Lcom/bytedance/android/ec/model/order/ProductDetailPageParams;", "detailPageParam", "Lcom/bytedance/android/btm/api/model/BtmItemBuilder;", "btmItemBuilder", "Lnl/d;", "clickBuyButtonCallback", "Lkotlin/Function1;", "Lcom/bytedance/android/ec/model/sku/SkuProductDetailInfo;", "refreshDetailInfoCallback", "jumpToPlaceOrder", "showSearchSimilarAuthorizationDialog", "requestShowSimilarProductGuide", "getSearchSimilarWhiteInstructionSchema", "getSearchSimilarBlackInstructionSchema", "taskRequestParams", "Lorg/json/JSONObject;", "jsEventSubscriber", "Landroid/view/ViewGroup;", KtvSubElement.CONTAINER, "showAwemeDetailLynxWidget", "position", "view", "Lcom/bytedance/android/ec/model/k;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lkotlin/Function0;", "dismissListener", "enterGalleryViewer", "checkQrcodePromotionSource", "Ln83/h;", "getMallService", "", "getBehaviorList", "getECGyroScopeImageBehavior", "bizTag", "sceneTag", "getImageBehaviors", "monitor", "supportAsyncCreateView", "enableImageAutoSize", "ecBehaviorAdd", "useNewImage", "schema", "isPopup", "checkNeedPrefetch", "commonProps", "lynxPrefetch", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "webPrefetch", "sceneName", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "getECFpsPerformanceMonitor", "start", "monitorId", "metricName", "startOrStopMetricDurationMonitor", "reportAndRemoveDurationMonitor", "monitorSceneName", "createDurationMonitor", "layoutResId", "needUseHandler", "preloadLayout", "layoutId", "parent", "attachToParent", "getViewByAsyncInflater", "getECMallService", "getBizComponentFetchers", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "promotion", "Lsc3/a;", "addCartListener", "Landroidx/fragment/app/Fragment;", WidgetService.PARAM_FRAGMENT, "roomId", "secAuthorId", "isLiveProduct", "ecomSceneId", "Lcom/bytedance/android/btm/api/model/d;", "btmModel", "doOnAddCartClicked", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;Lsc3/a;Landroid/content/Context;Landroidx/fragment/app/Fragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/bytedance/android/btm/api/model/d;)V", "Lvl/b;", "thirdParam", "openThirdPlatform", "Lcom/bytedance/android/shopping/anchorv3/AnchorV3Param;", "anchorV3Param", "isOnSec", "isGroupBuying", "promotionStruct", "btm", "Lcom/bytedance/android/shopping/feed/model/InflowFeedPageParams;", "inflowFeedPageParams", "Lcom/bytedance/android/shopping/anchorv3/utils/s;", "mallInflowParams", "Lcom/bytedance/android/ec/model/sku/SkuRestoreState;", "skuRestoreState", "saveSkuRestoreState", "onClickAddShopCartBtn", "mParam", "mPromotion", "mShareBtn", "Ln83/f;", "getAnchorV3ShareBtn", "toastIfAutoApplyCoupon", "shouldShowSaasCouponUrge", "Lkotlin/Function3;", "listener", "addBannerShowListener", "addBannerHideListener", "addBackViewAnimListener", "removeBackViewAnimListener", "urgeViewStyle", "Ln83/j;", "newCouponUrgeView", "Lsc3/f;", "getECClientAIService", "Ln83/d;", "hookLiveSchema", "Lcom/bytedance/android/shopping/api/mall/mallSession/IMallSessionService;", "getMallSessionService", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public interface IEShoppingService {
    void addBackViewAnimListener(Function1<? super Boolean, Unit> r100);

    void addBannerHideListener(Function1<? super String, Unit> r100);

    void addBannerShowListener(Function3<? super JSONObject, ? super String, ? super Boolean, Unit> r100);

    void agreeXiaoDianLaw();

    void checkLawHint(Context r100, long r101, Map<String, String> r102, Function2<? super Boolean, ? super Boolean, Unit> r103);

    boolean checkNeedPrefetch(String r100, boolean r101);

    boolean checkQrcodePromotionSource(Context r100, String r101);

    void clearRoomLifecycleData();

    View createCouponView(Context r100, List<d> r101);

    String createDurationMonitor(String r100);

    void doOnAddCartClicked(PromotionProductStruct r100, a r101, Context r102, Fragment r103, String r104, String r105, String r106, String r107, Boolean r108, String r110, com.bytedance.android.btm.api.model.d r111);

    List<Object> ecBehaviorAdd(Context r100, String r101);

    List<Object> ecBehaviorAdd(Context r100, String r101, boolean r102);

    void enterGalleryViewer(int r100, View r101, List<? extends k> r102, Function0<Unit> r103);

    c getAnchorInnerService();

    p83.d getAnchorV3Service();

    f getAnchorV3ShareBtn(AnchorV3Param r100, PromotionProductStruct r101, View r102);

    e getAnchorV3StoreService();

    n83.a getAppLifecycleObserver();

    List<?> getBehaviorList();

    Map<String, Object> getBizComponentFetchers();

    sc3.c getBuyNowService();

    sc3.d getCardKitService();

    sc3.e getCartService();

    g getCollectService();

    n83.g getECBoughtService();

    sc3.f getECClientAIService();

    RecyclerView.OnScrollListener getECFpsPerformanceMonitor(String r100);

    List<?> getECGyroScopeImageBehavior();

    h getECMallService();

    i getECVisualSearchService();

    List<?> getImageBehaviors(String r100, String r101, String r102);

    List<?> getImageBehaviors(String r100, String r101, Map<String, ? extends Object> r102, String r103, boolean r104, boolean r105);

    h getMallService();

    IMallSessionService getMallSessionService();

    n83.k getMonitorService();

    sc3.h getOrderListService();

    String getSearchSimilarBlackInstructionSchema();

    String getSearchSimilarWhiteInstructionSchema();

    sc3.i getSkuYataService();

    View getViewByAsyncInflater(Context r100, int r101, ViewGroup r102, boolean r103);

    j getYataService();

    boolean hideTaskBanner(String r100);

    n83.d hookLiveSchema(String r100);

    void jumpToPlaceOrder(FragmentActivity r100, ECOrderTrackerData r101, ProductPurchaseInfo r102, ProductDetailPageParams r103, BtmItemBuilder r104, nl.d r105, Function1<? super SkuProductDetailInfo, Unit> r106);

    String lynxPrefetch(String r100, JSONObject r101);

    n83.j newCouponUrgeView(Context r100, int r101);

    void onClickAddShopCartBtn(Fragment r100, AnchorV3Param r101, ProductDetailPageParams r102, boolean r103, boolean r104, PromotionProductStruct r105, String r106, com.bytedance.android.btm.api.model.d r107, InflowFeedPageParams r108, s r110, SkuRestoreState r111, Function1<? super SkuRestoreState, Unit> r112, Function1<? super SkuProductDetailInfo, Unit> r113);

    boolean onGetQrScanResult(String r100, int r101, int r102, String r103);

    void openTaobao(Context r100, String r101, String r102, String r103, String r104, String r105, String r106, Function2<? super Boolean, ? super Boolean, Unit> r107);

    void openThirdPlatform(Activity r100, b r101);

    void preloadLayout(Context r100, List<Integer> r101, boolean r102);

    void removeBackViewAnimListener();

    void reportAndRemoveDurationMonitor(String r100);

    void requestShowSimilarProductGuide();

    boolean shouldShowSaasCouponUrge();

    void showAwemeDetailLynxWidget(Context r100, String r101, Function1<? super JSONObject, Unit> r102, ViewGroup r103);

    void showSearchSimilarAuthorizationDialog(Context r100, String r101);

    String showTaskBanner(Context r100, Map<String, ? extends Object> r101, FrameLayout r102);

    void startOrStopMetricDurationMonitor(boolean r100, String r101, String r102);

    void startShowFloatInNextLifecycle(Activity r100, n83.c r101);

    void stopShowFloatInNextLifecycle();

    void switchBannerVisible(String r100, boolean r101);

    String toastIfAutoApplyCoupon(PromotionProductStruct r100, Context r101);

    HashMap<String, String> webPrefetch(String r100, JSONObject r101);
}
