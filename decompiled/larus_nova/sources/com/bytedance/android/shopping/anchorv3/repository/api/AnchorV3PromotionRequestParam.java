package com.bytedance.android.shopping.anchorv3.repository.api;

import android.text.TextUtils;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.android.shopping.anchorv3.utils.o;
import com.bytedance.android.shopping.anchorv4.params.V4ServerParams;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0003\b\u0087\u0001\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B¯\u0004\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001c\u0012\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001c\u0012\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\b\u0002\u0010(\u001a\u00020\u001a\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010+\u001a\u00020\u0005\u0012\b\b\u0002\u0010,\u001a\u00020\u001a\u0012\b\b\u0002\u0010-\u001a\u00020\u001a\u0012\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u00106J\t\u0010\u0082\u0001\u001a\u00020*H\u0016J\u0012\u0010\u0083\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010JJ\u0011\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010JJ\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010JJ\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u0010VJ\f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0018\u0010\u008f\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001cHÆ\u0003J\u0018\u0010\u0090\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001cHÆ\u0003J\u0018\u0010\u0091\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001cHÆ\u0003J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\"HÆ\u0003J\u0011\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010JJ\u0011\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u0010VJ\f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010JJ\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0012\u0010\u009a\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\n\u0010\u009b\u0001\u001a\u00020\u001aHÆ\u0003J\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010*HÆ\u0003J\n\u0010\u009d\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u009e\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010\u009f\u0001\u001a\u00020\u001aHÆ\u0003J\u0012\u0010 \u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u0011\u0010¡\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010JJ\u0011\u0010¢\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010JJ\f\u0010£\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\n\u0010¤\u0001\u001a\u00020\u0005HÆ\u0003J\u0011\u0010¥\u0001\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u0010VJ\f\u0010¦\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010§\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010¨\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010©\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\n\u0010ª\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010«\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003J\n\u0010¬\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u00ad\u0001\u001a\u00020\u0005HÆ\u0003Jº\u0004\u0010®\u0001\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001c2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001c2\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010(\u001a\u00020\u001a2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010+\u001a\u00020\u00052\b\b\u0002\u0010,\u001a\u00020\u001a2\b\b\u0002\u0010-\u001a\u00020\u001a2\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0003\u0010¯\u0001J\u0016\u0010°\u0001\u001a\u00020\u001a2\n\u0010±\u0001\u001a\u0005\u0018\u00010²\u0001HÖ\u0003J\u0007\u0010³\u0001\u001a\u00020\u001aJ\u0007\u0010´\u0001\u001a\u00020\u0012J\t\u0010µ\u0001\u001a\u0004\u0018\u00010\u0005J\t\u0010¶\u0001\u001a\u00020\u0005H\u0016J\u0007\u0010·\u0001\u001a\u00020\u0005J\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u0005J\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u0005J\u000b\u0010º\u0001\u001a\u0004\u0018\u00010*H\u0002J\n\u0010t\u001a\u0004\u0018\u00010*H\u0002J\t\u0010»\u0001\u001a\u00020\u0000H\u0016J\n\u0010¼\u0001\u001a\u00020\u0012HÖ\u0001J\t\u0010½\u0001\u001a\u00020\u001aH\u0016J\b\u0010$\u001a\u00020\u001aH\u0016J\n\u0010¾\u0001\u001a\u00020\u0005HÖ\u0001J\u0013\u0010¿\u0001\u001a\u00030À\u00012\u0007\u0010Á\u0001\u001a\u00020\u0005H\u0016J&\u0010Â\u0001\u001a\u00030À\u00012\t\u0010Ã\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010Ä\u0001\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0003\u0010Å\u0001J\u0015\u0010Æ\u0001\u001a\u00030À\u00012\t\u0010Ç\u0001\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010È\u0001\u001a\u00030À\u00012\u0006\u00102\u001a\u00020\u001aH\u0016J\u0013\u0010É\u0001\u001a\u00030À\u00012\u0007\u0010Ê\u0001\u001a\u00020\u001aH\u0016J\u0013\u0010Ë\u0001\u001a\u00030À\u00012\u0007\u0010Ì\u0001\u001a\u00020\u001aH\u0016J'\u0010Í\u0001\u001a\u00030À\u00012\u001b\u0010Î\u0001\u001a\u0016\u0012\u0004\u0012\u00020*\u0012\u0005\u0012\u00030À\u00010Ï\u0001¢\u0006\u0003\bÐ\u0001H\u0002J\u0015\u0010Ñ\u0001\u001a\u00030À\u00012\t\u0010Ò\u0001\u001a\u0004\u0018\u00010\u0005H\u0016J\u0015\u0010Ó\u0001\u001a\u00030À\u00012\t\u0010Ô\u0001\u001a\u0004\u0018\u00010\u0005H\u0016J\u001d\u0010Õ\u0001\u001a\u00030À\u00012\u0011\u0010Ö\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004H\u0016J\u001b\u0010×\u0001\u001a\u00030À\u00012\t\u0010Ø\u0001\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0003\u0010Ù\u0001J\u0015\u0010Ú\u0001\u001a\u00030À\u00012\t\u0010Ò\u0001\u001a\u0004\u0018\u00010\u0005H\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0013\u0010)\u001a\u0004\u0018\u00010*¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b=\u00108R\u0011\u0010+\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b>\u00108R\u0013\u00101\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u00108R\u001c\u0010@\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00108\"\u0004\bB\u0010:R\u0010\u0010C\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010D\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010<\"\u0004\bF\u0010GR\u0013\u0010%\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bH\u00108R\u0015\u0010&\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010K\u001a\u0004\bI\u0010JR\u0011\u0010(\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u001c\u0010 \u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u00108\"\u0004\bO\u0010:R(\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0013\u00104\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bT\u00108R\u001e\u00102\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u0010\n\u0002\u0010Y\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0015\u0010/\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010K\u001a\u0004\bZ\u0010JR\u0015\u00100\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010K\u001a\u0004\b[\u0010JR\u0019\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010K\u001a\u0004\b^\u0010JR\u0019\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010]R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010K\u001a\u0004\b`\u0010JR\u0011\u0010-\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b-\u0010MR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u0010\n\u0002\u0010Y\u001a\u0004\b\u0019\u0010V\"\u0004\ba\u0010XR\u001a\u0010b\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010M\"\u0004\bc\u0010dR\u0015\u0010$\u001a\u0004\u0018\u00010\u001a¢\u0006\n\n\u0002\u0010Y\u001a\u0004\b$\u0010VR\u0011\u0010,\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b,\u0010MR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\be\u00108R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u00108\"\u0004\bi\u0010:R\u0013\u00103\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bj\u00108R(\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010Q\"\u0004\bl\u0010SR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u00108\"\u0004\bn\u0010:R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bo\u00108R\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010]R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bq\u00108R\u001c\u00105\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u00108\"\u0004\bs\u0010:R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bt\u00108R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u00108\"\u0004\bv\u0010:R\u0015\u0010#\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010K\u001a\u0004\bw\u0010JR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bx\u00108R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\by\u00108R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bz\u00108R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b{\u00108R(\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010Q\"\u0004\b}\u0010SR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b~\u00108R\u0014\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\t\n\u0000\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u000b\n\u0002\u0010K\u001a\u0005\b\u0081\u0001\u0010J¨\u0006Û\u0001"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/repository/api/AnchorV3PromotionRequestParam;", "Lcom/bytedance/android/shopping/anchorv3/repository/api/PdpPackRequestParam;", "Ljava/io/Serializable;", "promotionIds", "", "", "promotionId", "itemId", "secAuthorId", "metaParam", "sourcePage", "lubanParam", "Lcom/bytedance/android/shopping/anchorv3/repository/api/LubanParam;", "userId", "secUserId", "requestAdditions", "authorId", "width", "", "height", "rankId", "internalFeedAB", "sourceType", "addressId", "roomId", "isFromVideo", "", "packApiImagesConstraint", "", "detailApiImagesConstraint", "storeRecommendApiImageConstraints", "productId", "creativeId", "v4ServerParams", "Lcom/bytedance/android/shopping/anchorv4/params/V4ServerParams;", "sameProductScene", "isPreload", RemoteMessageConst.Notification.CHANNEL_ID, "channelType", "identifiers", "clientCacheDisable", "aggParams", "Lorg/json/JSONObject;", "authorOpenId", "isStar", "isAds", "goodPriceParam", "goodPriceCardGuessLikeOpt", "goodPriceCardMainOpt", "bizCampaignType", "fullResp", "nGroupBuyToken", "ecomEntranceForm", "refreshReqParams", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv3/repository/api/LubanParam;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/params/V4ServerParams;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;ZLorg/json/JSONObject;Ljava/lang/String;ZZLjava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddressId", "()Ljava/lang/String;", "setAddressId", "(Ljava/lang/String;)V", "getAggParams", "()Lorg/json/JSONObject;", "getAuthorId", "getAuthorOpenId", "getBizCampaignType", "cachedEcomScenedId", "getCachedEcomScenedId", "setCachedEcomScenedId", "cachedMetaParamsJson", "cachedRequestAdditionsJson", "getCachedRequestAdditionsJson", "setCachedRequestAdditionsJson", "(Lorg/json/JSONObject;)V", "getChannelId", "getChannelType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getClientCacheDisable", "()Z", "getCreativeId", "setCreativeId", "getDetailApiImagesConstraint", "()Ljava/util/Map;", "setDetailApiImagesConstraint", "(Ljava/util/Map;)V", "getEcomEntranceForm", "getFullResp", "()Ljava/lang/Boolean;", "setFullResp", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getGoodPriceCardGuessLikeOpt", "getGoodPriceCardMainOpt", "getGoodPriceParam", "()Ljava/util/List;", "getHeight", "getIdentifiers", "getInternalFeedAB", "setFromVideo", "isPerfOpt", "setPerfOpt", "(Z)V", "getItemId", "getLubanParam", "()Lcom/bytedance/android/shopping/anchorv3/repository/api/LubanParam;", "getMetaParam", "setMetaParam", "getNGroupBuyToken", "getPackApiImagesConstraint", "setPackApiImagesConstraint", "getProductId", "setProductId", "getPromotionId", "getPromotionIds", "getRankId", "getRefreshReqParams", "setRefreshReqParams", "getRequestAdditions", "getRoomId", "setRoomId", "getSameProductScene", "getSecAuthorId", "getSecUserId", "getSourcePage", "getSourceType", "getStoreRecommendApiImageConstraints", "setStoreRecommendApiImageConstraints", "getUserId", "getV4ServerParams", "()Lcom/bytedance/android/shopping/anchorv4/params/V4ServerParams;", "getWidth", "asJsonDescription", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv3/repository/api/LubanParam;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/params/V4ServerParams;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;ZLorg/json/JSONObject;Ljava/lang/String;ZZLjava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/anchorv3/repository/api/AnchorV3PromotionRequestParam;", "equals", "other", "", "fromLive", "getCpsReportType", "getCpsTrack", "getEcomSceneId", "getEnterFrom", "getInflowMetaParam", "getMarketChannel", "getMetaParamsJson", "getSimplifiedCacheKey", "hashCode", "isInSplit", "toString", "updateAddressDetail", "", "addressList", "updateAddressId", "userAddressId", "userAddrType", "(Ljava/lang/String;Ljava/lang/Integer;)V", "updateClientStorage", "clientStorage", "updateFullResp", "updateIsAuth", "isAuth", "updateIsExpanded", "isExpanded", "updateMarketAddress", "modifyAddress", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "updateNormalSkuId", "normalSkuId", "updateRefreshRepParams", "params", "updateSelectedIds", "selectedIds", "updateShopRecommendTabIndex", "index", "(Ljava/lang/Integer;)V", "updateSkuSwitch", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class AnchorV3PromotionRequestParam extends PdpPackRequestParam {
    private String addressId;
    private final JSONObject aggParams;
    private final String authorId;
    private final String authorOpenId;
    private final String bizCampaignType;
    private String cachedEcomScenedId;
    private transient JSONObject cachedMetaParamsJson;
    private transient JSONObject cachedRequestAdditionsJson;
    private final String channelId;
    private final Integer channelType;
    private final boolean clientCacheDisable;
    private String creativeId;
    private Map<String, String> detailApiImagesConstraint;
    private final String ecomEntranceForm;
    private Boolean fullResp;
    private final Integer goodPriceCardGuessLikeOpt;
    private final Integer goodPriceCardMainOpt;
    private final List<String> goodPriceParam;
    private final Integer height;
    private final List<String> identifiers;
    private final Integer internalFeedAB;
    private final boolean isAds;
    private Boolean isFromVideo;
    private boolean isPerfOpt;
    private final Boolean isPreload;
    private final boolean isStar;
    private final String itemId;
    private final LubanParam lubanParam;
    private String metaParam;
    private final String nGroupBuyToken;
    private Map<String, String> packApiImagesConstraint;
    private String productId;
    private final String promotionId;
    private final List<String> promotionIds;
    private final String rankId;
    private String refreshReqParams;
    private final String requestAdditions;
    private String roomId;
    private final Integer sameProductScene;
    private final String secAuthorId;
    private final String secUserId;
    private final String sourcePage;
    private final String sourceType;
    private Map<String, String> storeRecommendApiImageConstraints;
    private final String userId;
    private final V4ServerParams v4ServerParams;
    private final Integer width;

    public AnchorV3PromotionRequestParam() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, null, null, null, null, null, null, null, -1, 2047, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV3PromotionRequestParam copy$default(AnchorV3PromotionRequestParam r110, List r111, String r112, String r210, String r211, String r212, String r213, LubanParam r214, String r215, String r216, String r217, String r218, Integer r219, Integer r310, String r311, Integer r312, String r313, String r314, String r315, Boolean r316, Map r317, Map r318, Map r319, String r410, String r411, V4ServerParams r412, Integer r413, Boolean r414, String r415, Integer r416, List r417, boolean r418, JSONObject r419, String r510, boolean r511, boolean r512, List r513, Integer r514, Integer r515, String r516, Boolean r517, String r518, String r519, String r610, int r611, int r612, Object r613) {
        if ((r611 & 1) == 0) goto L5;
        List r100 = r110.promotionIds;
    L7:
        if ((r611 & 2) == 0) goto L9;
        String r101 = r110.promotionId;
    L11:
        if ((r611 & 4) == 0) goto L13;
        String r102 = r110.itemId;
    L15:
        if ((r611 & 8) == 0) goto L17;
        String r103 = r110.secAuthorId;
    L19:
        if ((r611 & 16) == 0) goto L21;
        String r104 = r110.metaParam;
    L23:
        if ((r611 & 32) == 0) goto L25;
        String r105 = r110.sourcePage;
    L27:
        if ((r611 & 64) == 0) goto L29;
        LubanParam r106 = r110.lubanParam;
    L31:
        if ((r611 & 128) == 0) goto L33;
        String r113 = r110.userId;
    L35:
        if ((r611 & 256) == 0) goto L37;
        String r114 = r110.secUserId;
    L39:
        if ((r611 & 512) == 0) goto L41;
        String r115 = r110.requestAdditions;
    L43:
        if ((r611 & 1024) == 0) goto L45;
        String r116 = r110.authorId;
    L47:
        if ((r611 & 2048) == 0) goto L49;
        Integer r117 = r110.width;
    L51:
        if ((r611 & 4096) == 0) goto L53;
        Integer r118 = r110.height;
    L54:
        Integer r320 = r118;
        if ((r611 & 8192) == 0) goto L57;
        String r119 = r110.rankId;
    L58:
        String r321 = r119;
        if ((r611 & 16384) == 0) goto L61;
        Integer r120 = r110.internalFeedAB;
    L62:
        Integer r322 = r120;
        if ((r611 & 32768) == 0) goto L65;
        String r121 = r110.sourceType;
    L66:
        String r323 = r121;
        if ((r611 & 65536) == 0) goto L69;
        String r122 = r110.addressId;
    L70:
        String r324 = r122;
        if ((r611 & 131072) == 0) goto L73;
        String r123 = r110.roomId;
    L74:
        String r325 = r123;
        if ((r611 & 262144) == 0) goto L77;
        Boolean r124 = r110.isFromVideo;
    L78:
        Boolean r326 = r124;
        if ((r611 & 524288) == 0) goto L81;
        Map r125 = r110.packApiImagesConstraint;
    L82:
        Map r327 = r125;
        if ((r611 & 1048576) == 0) goto L85;
        Map r126 = r110.detailApiImagesConstraint;
    L86:
        Map r328 = r126;
        if ((r611 & 2097152) == 0) goto L89;
        Map r127 = r110.storeRecommendApiImageConstraints;
    L90:
        Map r329 = r127;
        if ((r611 & 4194304) == 0) goto L93;
        String r128 = r110.productId;
    L94:
        String r420 = r128;
        if ((r611 & 8388608) == 0) goto L97;
        String r129 = r110.creativeId;
    L98:
        String r421 = r129;
        if ((r611 & 16777216) == 0) goto L101;
        V4ServerParams r130 = r110.v4ServerParams;
    L102:
        V4ServerParams r422 = r130;
        if ((r611 & 33554432) == 0) goto L105;
        Integer r131 = r110.sameProductScene;
    L106:
        Integer r423 = r131;
        if ((r611 & 67108864) == 0) goto L109;
        Boolean r132 = r110.isPreload;
    L110:
        Boolean r424 = r132;
        if ((r611 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        String r133 = r110.channelId;
    L114:
        String r425 = r133;
        if ((r611 & 268435456) == 0) goto L117;
        Integer r134 = r110.channelType;
    L118:
        Integer r426 = r134;
        if ((r611 & 536870912) == 0) goto L121;
        List r135 = r110.identifiers;
    L122:
        List r427 = r135;
        if ((r611 & 1073741824) == 0) goto L125;
        boolean r136 = r110.clientCacheDisable;
    L127:
        if ((r611 & Integer.MIN_VALUE) == 0) goto L129;
        JSONObject r107 = r110.aggParams;
    L130:
        JSONObject r428 = r107;
        if ((r612 & 1) == 0) goto L133;
        String r108 = r110.authorOpenId;
    L134:
        String r520 = r108;
        if ((r612 & 2) == 0) goto L137;
        boolean r109 = r110.isStar;
    L138:
        boolean r521 = r109;
        if ((r612 & 4) == 0) goto L141;
        boolean r137 = r110.isAds;
    L142:
        boolean r522 = r137;
        if ((r612 & 8) == 0) goto L145;
        List r138 = r110.goodPriceParam;
    L146:
        List r523 = r138;
        if ((r612 & 16) == 0) goto L149;
        Integer r139 = r110.goodPriceCardGuessLikeOpt;
    L150:
        Integer r524 = r139;
        if ((r612 & 32) == 0) goto L153;
        Integer r140 = r110.goodPriceCardMainOpt;
    L154:
        Integer r525 = r140;
        if ((r612 & 64) == 0) goto L157;
        String r141 = r110.bizCampaignType;
    L158:
        String r526 = r141;
        if ((r612 & 128) == 0) goto L161;
        Boolean r142 = r110.fullResp;
    L162:
        Boolean r527 = r142;
        if ((r612 & 256) == 0) goto L165;
        String r143 = r110.nGroupBuyToken;
    L166:
        String r528 = r143;
        if ((r612 & 512) == 0) goto L169;
        String r144 = r110.ecomEntranceForm;
    L171:
        if ((r612 & 1024) == 0) goto L173;
        String r145 = r110.refreshReqParams;
    L175:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r329, r420, r421, r422, r423, r424, r425, r426, r427, r136, r428, r520, r521, r522, r523, r524, r525, r526, r527, r528, r144, r145);
    L173:
        r145 = r610;
        goto L175
    L169:
        r144 = r519;
        goto L171
    L165:
        r143 = r518;
        goto L166
    L161:
        r142 = r517;
        goto L162
    L157:
        r141 = r516;
        goto L158
    L153:
        r140 = r515;
        goto L154
    L149:
        r139 = r514;
        goto L150
    L145:
        r138 = r513;
        goto L146
    L141:
        r137 = r512;
        goto L142
    L137:
        r109 = r511;
        goto L138
    L133:
        r108 = r510;
        goto L134
    L129:
        r107 = r419;
        goto L130
    L125:
        r136 = r418;
        goto L127
    L121:
        r135 = r417;
        goto L122
    L117:
        r134 = r416;
        goto L118
    L113:
        r133 = r415;
        goto L114
    L109:
        r132 = r414;
        goto L110
    L105:
        r131 = r413;
        goto L106
    L101:
        r130 = r412;
        goto L102
    L97:
        r129 = r411;
        goto L98
    L93:
        r128 = r410;
        goto L94
    L89:
        r127 = r319;
        goto L90
    L85:
        r126 = r318;
        goto L86
    L81:
        r125 = r317;
        goto L82
    L77:
        r124 = r316;
        goto L78
    L73:
        r123 = r315;
        goto L74
    L69:
        r122 = r314;
        goto L70
    L65:
        r121 = r313;
        goto L66
    L61:
        r120 = r312;
        goto L62
    L57:
        r119 = r311;
        goto L58
    L53:
        r118 = r310;
        goto L54
    L49:
        r117 = r219;
        goto L51
    L45:
        r116 = r218;
        goto L47
    L41:
        r115 = r217;
        goto L43
    L37:
        r114 = r216;
        goto L39
    L33:
        r113 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final List<String> component1() {
        return this.promotionIds;
    }

    public final String component10() {
        return this.requestAdditions;
    }

    public final String component11() {
        return this.authorId;
    }

    public final Integer component12() {
        return this.width;
    }

    public final Integer component13() {
        return this.height;
    }

    public final String component14() {
        return this.rankId;
    }

    public final Integer component15() {
        return this.internalFeedAB;
    }

    public final String component16() {
        return this.sourceType;
    }

    public final String component17() {
        return this.addressId;
    }

    public final String component18() {
        return this.roomId;
    }

    public final Boolean component19() {
        return this.isFromVideo;
    }

    public final String component2() {
        return this.promotionId;
    }

    public final Map<String, String> component20() {
        return this.packApiImagesConstraint;
    }

    public final Map<String, String> component21() {
        return this.detailApiImagesConstraint;
    }

    public final Map<String, String> component22() {
        return this.storeRecommendApiImageConstraints;
    }

    public final String component23() {
        return this.productId;
    }

    public final String component24() {
        return this.creativeId;
    }

    public final V4ServerParams component25() {
        return this.v4ServerParams;
    }

    public final Integer component26() {
        return this.sameProductScene;
    }

    public final Boolean component27() {
        return this.isPreload;
    }

    public final String component28() {
        return this.channelId;
    }

    public final Integer component29() {
        return this.channelType;
    }

    public final String component3() {
        return this.itemId;
    }

    public final List<String> component30() {
        return this.identifiers;
    }

    public final boolean component31() {
        return this.clientCacheDisable;
    }

    public final JSONObject component32() {
        return this.aggParams;
    }

    public final String component33() {
        return this.authorOpenId;
    }

    public final boolean component34() {
        return this.isStar;
    }

    public final boolean component35() {
        return this.isAds;
    }

    public final List<String> component36() {
        return this.goodPriceParam;
    }

    public final Integer component37() {
        return this.goodPriceCardGuessLikeOpt;
    }

    public final Integer component38() {
        return this.goodPriceCardMainOpt;
    }

    public final String component39() {
        return this.bizCampaignType;
    }

    public final String component4() {
        return this.secAuthorId;
    }

    public final Boolean component40() {
        return this.fullResp;
    }

    public final String component41() {
        return this.nGroupBuyToken;
    }

    public final String component42() {
        return this.ecomEntranceForm;
    }

    public final String component43() {
        return this.refreshReqParams;
    }

    public final String component5() {
        return this.metaParam;
    }

    public final String component6() {
        return this.sourcePage;
    }

    public final LubanParam component7() {
        return this.lubanParam;
    }

    public final String component8() {
        return this.userId;
    }

    public final String component9() {
        return this.secUserId;
    }

    public final AnchorV3PromotionRequestParam copy(List<String> r410, String r411, String r412, String r413, String r510, String r511, LubanParam r512, String r513, String r514, String r515, String r516, Integer r517, Integer r518, String r519, Integer r610, String r611, String r612, String r613, Boolean r614, Map<String, String> r615, Map<String, String> r616, Map<String, String> r617, String r618, String r619, V4ServerParams r710, Integer r711, Boolean r712, String r713, Integer r714, List<String> r715, boolean r716, JSONObject r717, String r718, boolean r719, boolean r810, List<String> r811, Integer r812, Integer r813, String r814, Boolean r815, String r816, String r817, String r818) {
        Intrinsics.checkNotNullParameter(r413, "secAuthorId");
        Intrinsics.checkNotNullParameter(r511, "sourcePage");
        Intrinsics.checkNotNullParameter(r513, "userId");
        Intrinsics.checkNotNullParameter(r514, "secUserId");
        Intrinsics.checkNotNullParameter(r718, "authorOpenId");
        return new AnchorV3PromotionRequestParam(r410, r411, r412, r413, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, r813, r814, r815, r816, r817, r818);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV3PromotionRequestParam) == false) goto L92;
        AnchorV3PromotionRequestParam r101 = (AnchorV3PromotionRequestParam) r100;
        if (Intrinsics.areEqual(this.promotionIds, r101.promotionIds) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.promotionId, r101.promotionId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.secAuthorId, r101.secAuthorId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.metaParam, r101.metaParam) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.sourcePage, r101.sourcePage) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lubanParam, r101.lubanParam) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.secUserId, r101.secUserId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.requestAdditions, r101.requestAdditions) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.authorId, r101.authorId) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.rankId, r101.rankId) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.internalFeedAB, r101.internalFeedAB) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.sourceType, r101.sourceType) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.addressId, r101.addressId) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.isFromVideo, r101.isFromVideo) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.packApiImagesConstraint, r101.packApiImagesConstraint) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.detailApiImagesConstraint, r101.detailApiImagesConstraint) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.storeRecommendApiImageConstraints, r101.storeRecommendApiImageConstraints) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.creativeId, r101.creativeId) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.v4ServerParams, r101.v4ServerParams) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.sameProductScene, r101.sameProductScene) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.isPreload, r101.isPreload) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.channelId, r101.channelId) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.channelType, r101.channelType) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.identifiers, r101.identifiers) == true) goto L66;
        return false;
    L66:
        if (this.clientCacheDisable == r101.clientCacheDisable) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.aggParams, r101.aggParams) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.authorOpenId, r101.authorOpenId) == true) goto L72;
        return false;
    L72:
        if (this.isStar == r101.isStar) goto L74;
        return false;
    L74:
        if (this.isAds == r101.isAds) goto L76;
        return false;
    L76:
        if (Intrinsics.areEqual(this.goodPriceParam, r101.goodPriceParam) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.goodPriceCardGuessLikeOpt, r101.goodPriceCardGuessLikeOpt) == true) goto L80;
        return false;
    L80:
        if (Intrinsics.areEqual(this.goodPriceCardMainOpt, r101.goodPriceCardMainOpt) == true) goto L82;
        return false;
    L82:
        if (Intrinsics.areEqual(this.bizCampaignType, r101.bizCampaignType) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.fullResp, r101.fullResp) == true) goto L86;
        return false;
    L86:
        if (Intrinsics.areEqual(this.nGroupBuyToken, r101.nGroupBuyToken) == true) goto L88;
        return false;
    L88:
        if (Intrinsics.areEqual(this.ecomEntranceForm, r101.ecomEntranceForm) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.refreshReqParams, r101.refreshReqParams) == true) goto L139;
        return false;
    L139:
        return true;
    L92:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v127 */
    /* JADX WARN: Type inference failed for: r2v130 */
    /* JADX WARN: Type inference failed for: r2v160 */
    /* JADX WARN: Type inference failed for: r2v161 */
    /* JADX WARN: Type inference failed for: r2v88, types: [int] */
    /* JADX WARN: Type inference failed for: r2v96, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        List<String> r100 = this.promotionIds;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.promotionId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.itemId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.secAuthorId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.metaParam;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.sourcePage;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        LubanParam r119 = this.lubanParam;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.userId;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.secUserId;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.requestAdditions;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.authorId;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.width;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.height;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.rankId;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        Integer r143 = this.internalFeedAB;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.sourceType;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.addressId;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.roomId;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        Boolean r155 = this.isFromVideo;
        if (r155 == null) goto L77;
        int r156 = r155.hashCode();
    L78:
        int r157 = (r154 + r156) * 31;
        Map<String, String> r158 = this.packApiImagesConstraint;
        if (r158 == null) goto L81;
        int r159 = r158.hashCode();
    L82:
        int r160 = (r157 + r159) * 31;
        Map<String, String> r161 = this.detailApiImagesConstraint;
        if (r161 == null) goto L85;
        int r162 = r161.hashCode();
    L86:
        int r163 = (r160 + r162) * 31;
        Map<String, String> r164 = this.storeRecommendApiImageConstraints;
        if (r164 == null) goto L89;
        int r165 = r164.hashCode();
    L90:
        int r166 = (r163 + r165) * 31;
        String r167 = this.productId;
        if (r167 == null) goto L93;
        int r168 = r167.hashCode();
    L94:
        int r169 = (r166 + r168) * 31;
        String r170 = this.creativeId;
        if (r170 == null) goto L97;
        int r171 = r170.hashCode();
    L98:
        int r172 = (r169 + r171) * 31;
        V4ServerParams r173 = this.v4ServerParams;
        if (r173 == null) goto L101;
        int r174 = r173.hashCode();
    L102:
        int r175 = (r172 + r174) * 31;
        Integer r176 = this.sameProductScene;
        if (r176 == null) goto L105;
        int r177 = r176.hashCode();
    L106:
        int r178 = (r175 + r177) * 31;
        Boolean r179 = this.isPreload;
        if (r179 == null) goto L109;
        int r180 = r179.hashCode();
    L110:
        int r181 = (r178 + r180) * 31;
        String r182 = this.channelId;
        if (r182 == null) goto L113;
        int r183 = r182.hashCode();
    L114:
        int r184 = (r181 + r183) * 31;
        Integer r185 = this.channelType;
        if (r185 == null) goto L117;
        int r186 = r185.hashCode();
    L118:
        int r187 = (r184 + r186) * 31;
        List<String> r188 = this.identifiers;
        if (r188 == null) goto L121;
        int r189 = r188.hashCode();
    L122:
        int r190 = (r187 + r189) * 31;
        boolean r191 = this.clientCacheDisable;
        ?? r192 = 1;
        ?? r193 = r191;
        if (r191 == false) goto L125;
        r193 = 1;
    L125:
        int r194 = (r190 + r193) * 31;
        JSONObject r195 = this.aggParams;
        if (r195 == null) goto L128;
        int r196 = r195.hashCode();
    L129:
        int r197 = (r194 + r196) * 31;
        String r198 = this.authorOpenId;
        if (r198 == null) goto L132;
        int r199 = r198.hashCode();
    L133:
        int r200 = (r197 + r199) * 31;
        boolean r201 = this.isStar;
        ?? r202 = r201;
        if (r201 == false) goto L136;
        r202 = 1;
    L136:
        int r203 = (r200 + r202) * 31;
        boolean r204 = this.isAds;
        if (r204 == true) goto L140;
        r192 = r204;
    L140:
        int r205 = (r203 + r192) * 31;
        List<String> r206 = this.goodPriceParam;
        if (r206 == null) goto L143;
        int r207 = r206.hashCode();
    L144:
        int r208 = (r205 + r207) * 31;
        Integer r209 = this.goodPriceCardGuessLikeOpt;
        if (r209 == null) goto L147;
        int r210 = r209.hashCode();
    L148:
        int r211 = (r208 + r210) * 31;
        Integer r212 = this.goodPriceCardMainOpt;
        if (r212 == null) goto L151;
        int r213 = r212.hashCode();
    L152:
        int r214 = (r211 + r213) * 31;
        String r215 = this.bizCampaignType;
        if (r215 == null) goto L155;
        int r216 = r215.hashCode();
    L156:
        int r217 = (r214 + r216) * 31;
        Boolean r218 = this.fullResp;
        if (r218 == null) goto L159;
        int r219 = r218.hashCode();
    L160:
        int r220 = (r217 + r219) * 31;
        String r221 = this.nGroupBuyToken;
        if (r221 == null) goto L163;
        int r222 = r221.hashCode();
    L164:
        int r223 = (r220 + r222) * 31;
        String r224 = this.ecomEntranceForm;
        if (r224 == null) goto L167;
        int r225 = r224.hashCode();
    L168:
        int r226 = (r223 + r225) * 31;
        String r227 = this.refreshReqParams;
        if (r227 == null) goto L172;
        r101 = r227.hashCode();
    L172:
        return r226 + r101;
    L167:
        r225 = 0;
        goto L168
    L163:
        r222 = 0;
        goto L164
    L159:
        r219 = 0;
        goto L160
    L155:
        r216 = 0;
        goto L156
    L151:
        r213 = 0;
        goto L152
    L147:
        r210 = 0;
        goto L148
    L143:
        r207 = 0;
        goto L144
    L132:
        r199 = 0;
        goto L133
    L128:
        r196 = 0;
        goto L129
    L121:
        r189 = 0;
        goto L122
    L117:
        r186 = 0;
        goto L118
    L113:
        r183 = 0;
        goto L114
    L109:
        r180 = 0;
        goto L110
    L105:
        r177 = 0;
        goto L106
    L101:
        r174 = 0;
        goto L102
    L97:
        r171 = 0;
        goto L98
    L93:
        r168 = 0;
        goto L94
    L89:
        r165 = 0;
        goto L90
    L85:
        r162 = 0;
        goto L86
    L81:
        r159 = 0;
        goto L82
    L77:
        r156 = 0;
        goto L78
    L73:
        r153 = 0;
        goto L74
    L69:
        r150 = 0;
        goto L70
    L65:
        r147 = 0;
        goto L66
    L61:
        r144 = 0;
        goto L62
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorV3PromotionRequestParam(promotionIds=" + this.promotionIds + ", promotionId=" + this.promotionId + ", itemId=" + this.itemId + ", secAuthorId=" + this.secAuthorId + ", metaParam=" + this.metaParam + ", sourcePage=" + this.sourcePage + ", lubanParam=" + this.lubanParam + ", userId=" + this.userId + ", secUserId=" + this.secUserId + ", requestAdditions=" + this.requestAdditions + ", authorId=" + this.authorId + ", width=" + this.width + ", height=" + this.height + ", rankId=" + this.rankId + ", internalFeedAB=" + this.internalFeedAB + ", sourceType=" + this.sourceType + ", addressId=" + this.addressId + ", roomId=" + this.roomId + ", isFromVideo=" + this.isFromVideo + ", packApiImagesConstraint=" + this.packApiImagesConstraint + ", detailApiImagesConstraint=" + this.detailApiImagesConstraint + ", storeRecommendApiImageConstraints=" + this.storeRecommendApiImageConstraints + ", productId=" + this.productId + ", creativeId=" + this.creativeId + ", v4ServerParams=" + this.v4ServerParams + ", sameProductScene=" + this.sameProductScene + ", isPreload=" + this.isPreload + ", channelId=" + this.channelId + ", channelType=" + this.channelType + ", identifiers=" + this.identifiers + ", clientCacheDisable=" + this.clientCacheDisable + ", aggParams=" + this.aggParams + ", authorOpenId=" + this.authorOpenId + ", isStar=" + this.isStar + ", isAds=" + this.isAds + ", goodPriceParam=" + this.goodPriceParam + ", goodPriceCardGuessLikeOpt=" + this.goodPriceCardGuessLikeOpt + ", goodPriceCardMainOpt=" + this.goodPriceCardMainOpt + ", bizCampaignType=" + this.bizCampaignType + ", fullResp=" + this.fullResp + ", nGroupBuyToken=" + this.nGroupBuyToken + ", ecomEntranceForm=" + this.ecomEntranceForm + ", refreshReqParams=" + this.refreshReqParams + ")";
    }

    private final JSONObject getMetaParamsJson() {
        if (this.isPerfOpt == false) goto L9;
        if (this.cachedMetaParamsJson != null) goto L10;
        this.cachedMetaParamsJson = com.bytedance.android.shopping.anchorv3.a.d(this.metaParam);
    L10:
        return this.cachedMetaParamsJson;
    L9:
        return com.bytedance.android.shopping.anchorv3.a.d(this.metaParam);
    }

    private final JSONObject getRequestAdditions() {
        if (this.isPerfOpt == false) goto L9;
        if (this.cachedRequestAdditionsJson != null) goto L10;
        this.cachedRequestAdditionsJson = com.bytedance.android.shopping.anchorv3.a.d(this.requestAdditions);
    L10:
        return this.cachedRequestAdditionsJson;
    L9:
        return com.bytedance.android.shopping.anchorv3.a.d(this.requestAdditions);
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public JSONObject asJsonDescription() {
        JSONObject r100 = new JSONObject();
        List<String> r101 = this.promotionIds;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = CollectionsKt.joinToString$default(r101, ",", null, null, 0, null, null, 62, null);
    L6:
        r100.put("promotion_ids", r103);
        r100.put("item_id", this.itemId);
        r100.put("sec_author_id", this.secAuthorId);
        r100.put(com.bytedance.android.ec.core.event.a.KEY_META_PARAM, this.metaParam);
        r100.put("source_page", this.sourcePage);
        r100.put("luban_param", this.lubanParam);
        r100.put("user_id", this.userId);
        r100.put("sec_user_id", this.secUserId);
        r100.put(com.bytedance.android.ec.core.event.a.KEY_REQUEST_ADDITIONS, this.requestAdditions);
        r100.put("author_id", this.authorId);
        r100.put("width", this.width);
        r100.put("height", this.height);
        r100.put(com.bytedance.android.ec.core.event.a.KEY_RANK_ID, this.rankId);
        r100.put("internal_feed_ab", this.internalFeedAB);
        r100.put("source_type", this.sourceType);
        r100.put("address_id", this.addressId);
        r100.put("room_id", this.roomId);
        r100.put("product_id", this.productId);
        r100.put("creative_id", this.creativeId);
        r100.put("promotion_id", this.promotionId);
        r100.put("v4_server_params", GsonProtectorUtils.toJson(o.a(), this.v4ServerParams));
        Map<String, String> r104 = this.packApiImagesConstraint;
        if (r104 == null) goto L13;
        ArrayList r105 = new ArrayList(r104.size());
        Iterator<Map.Entry<String, String>> r106 = r104.entrySet().iterator();
    L10:
        if (r106.hasNext() == false) goto L12;
        Map.Entry<String, String> r107 = r106.next();
        r105.add(r107.getKey() + r107.getValue());
        goto L10
    L12:
        String r108 = CollectionsKt.joinToString$default(r105, ",", null, null, 0, null, null, 62, null);
    L14:
        r100.put("pack_image_constraints", r108);
        Map<String, String> r109 = this.detailApiImagesConstraint;
        if (r109 == null) goto L21;
        ArrayList r110 = new ArrayList(r109.size());
        Iterator<Map.Entry<String, String>> r111 = r109.entrySet().iterator();
    L18:
        if (r111.hasNext() == false) goto L20;
        Map.Entry<String, String> r112 = r111.next();
        r110.add(r112.getKey() + r112.getValue());
        goto L18
    L20:
        String r113 = CollectionsKt.joinToString$default(r110, ",", null, null, 0, null, null, 62, null);
    L22:
        r100.put("detail_image_constraints", r113);
        Map<String, String> r114 = this.storeRecommendApiImageConstraints;
        if (r114 == null) goto L29;
        ArrayList r115 = new ArrayList(r114.size());
        Iterator<Map.Entry<String, String>> r116 = r114.entrySet().iterator();
    L26:
        if (r116.hasNext() == false) goto L28;
        Map.Entry<String, String> r117 = r116.next();
        r115.add(r117.getKey() + r117.getValue());
        goto L26
    L28:
        r102 = CollectionsKt.joinToString$default(r115, ",", null, null, 0, null, null, 62, null);
    L29:
        r100.put("store_recommend_image_constraints", r102);
        r100.put("channel_id", this.channelId);
        r100.put(WsConstants.KEY_CHANNEL_TYPE, this.channelType);
        return r100;
    L21:
        r113 = null;
        goto L22
    L13:
        r108 = null;
        goto L14
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public String getEcomSceneId() {
        if (this.isPerfOpt == false) goto L9;
        String r100 = this.cachedEcomScenedId;
        if (r100 != null) goto L8;
        return "";
    L8:
        return r100;
    L9:
        JSONObject r101 = getMetaParamsJson();
        if (r101 == null) goto L16;
        String r102 = r101.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if (r102 == null) goto L16;
        JSONObject r103 = com.bytedance.android.shopping.anchorv3.a.d(r102);
        if (r103 == null) goto L16;
        String r104 = r103.optString("ecom_scene_id");
    L17:
        if (r104 != null) goto L20;
        return "";
    L20:
        return r104;
    L16:
        r104 = null;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public AnchorV3PromotionRequestParam getSimplifiedCacheKey() {
        ArrayList r110 = new ArrayList();
        List<String> r100 = this.promotionIds;
        if (r100 == null) goto L8;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r110.add((String) r101.next());
    L8:
        r110.add(this.userId);
        String r102 = this.authorId;
        String r103 = "";
        if (r102 != null) goto L11;
        r102 = "";
    L11:
        r110.add(r102);
        r110.add(getEnterFrom());
        String r104 = getMarketChannel();
        if (r104 == null) goto L15;
        r103 = r104;
    L15:
        r110.add(r103);
        r110.add(getEcomSceneId());
        r110.add(String.valueOf(isInSplit()));
        Object[] r111 = 0 == true ? 1 : 0;
        return new AnchorV3PromotionRequestParam(null, null, null, null, null, null, null, null, null, null, null, null, null, null, r111, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r110, false, null, null, false, false, null, null, null, null, null, null, null, null, -536870913, 2047, null);
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public boolean isInSplit() {
        V4ServerParams r100 = this.v4ServerParams;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isInSplit() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    /* JADX INFO: renamed from: isPreload, reason: collision with other method in class */
    public boolean mo8285isPreload() {
        return Intrinsics.areEqual(this.isPreload, Boolean.TRUE);
    }

    public final boolean fromLive() {
        JSONObject r100 = getMetaParamsJson();
        if (r100 == null) goto L9;
        String r101 = r100.optString(MiniAppConstants.KEY_MINI_APP_LIVE_ROOM_ID);
        if (r101 == null) goto L9;
        if (com.bytedance.android.shopping.anchorv3.a.b(r101) != true) goto L9;
        return true;
    L9:
        if (TextUtils.equals(this.sourcePage, "live") == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int getCpsReportType() {
        JSONObject r100 = getRequestAdditions();
        if (r100 != null) goto L5;
        return 1;
    L5:
        return r100.optInt("cps_report_type", 1);
    }

    public final String getCpsTrack() {
        JSONObject r100 = getRequestAdditions();
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.optString("cps_track", null);
    }

    public final String getEnterFrom() {
        JSONObject r100 = getRequestAdditions();
        if (r100 == null) goto L7;
        String r101 = r100.optString("enter_from", null);
        if (r101 == null) goto L7;
        return r101;
    L7:
        return this.sourcePage;
    }

    public final String getInflowMetaParam() {
        JSONObject r100 = getRequestAdditions();
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.optString("inflow_meta_param", null);
    }

    public final String getMarketChannel() {
        JSONObject r100 = getRequestAdditions();
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.optString(com.bytedance.android.ec.core.event.a.KEY_MARKET_CHANNEL, null);
    }

    public final String getAddressId() {
        return this.addressId;
    }

    public final JSONObject getAggParams() {
        return this.aggParams;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getAuthorOpenId() {
        return this.authorOpenId;
    }

    public final String getBizCampaignType() {
        return this.bizCampaignType;
    }

    public final String getCachedEcomScenedId() {
        return this.cachedEcomScenedId;
    }

    public final JSONObject getCachedRequestAdditionsJson() {
        return this.cachedRequestAdditionsJson;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final Integer getChannelType() {
        return this.channelType;
    }

    public final boolean getClientCacheDisable() {
        return this.clientCacheDisable;
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final Map<String, String> getDetailApiImagesConstraint() {
        return this.detailApiImagesConstraint;
    }

    public final String getEcomEntranceForm() {
        return this.ecomEntranceForm;
    }

    public final Boolean getFullResp() {
        return this.fullResp;
    }

    public final Integer getGoodPriceCardGuessLikeOpt() {
        return this.goodPriceCardGuessLikeOpt;
    }

    public final Integer getGoodPriceCardMainOpt() {
        return this.goodPriceCardMainOpt;
    }

    public final List<String> getGoodPriceParam() {
        return this.goodPriceParam;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final List<String> getIdentifiers() {
        return this.identifiers;
    }

    public final Integer getInternalFeedAB() {
        return this.internalFeedAB;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final LubanParam getLubanParam() {
        return this.lubanParam;
    }

    public final String getMetaParam() {
        return this.metaParam;
    }

    public final String getNGroupBuyToken() {
        return this.nGroupBuyToken;
    }

    public final Map<String, String> getPackApiImagesConstraint() {
        return this.packApiImagesConstraint;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final List<String> getPromotionIds() {
        return this.promotionIds;
    }

    public final String getRankId() {
        return this.rankId;
    }

    public final String getRefreshReqParams() {
        return this.refreshReqParams;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final Integer getSameProductScene() {
        return this.sameProductScene;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final String getSecUserId() {
        return this.secUserId;
    }

    public final String getSourcePage() {
        return this.sourcePage;
    }

    public final String getSourceType() {
        return this.sourceType;
    }

    public final Map<String, String> getStoreRecommendApiImageConstraints() {
        return this.storeRecommendApiImageConstraints;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final V4ServerParams getV4ServerParams() {
        return this.v4ServerParams;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final boolean isAds() {
        return this.isAds;
    }

    public final Boolean isFromVideo() {
        return this.isFromVideo;
    }

    public final boolean isPerfOpt() {
        return this.isPerfOpt;
    }

    public final boolean isStar() {
        return this.isStar;
    }

    /* JADX INFO: renamed from: getRequestAdditions, reason: collision with other method in class */
    public final String m8284getRequestAdditions() {
        return this.requestAdditions;
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public /* bridge */ /* synthetic */ PdpPackRequestParam getSimplifiedCacheKey() {
        return getSimplifiedCacheKey();
    }

    public final Boolean isPreload() {
        return this.isPreload;
    }

    private final void updateMarketAddress(Function1<? super JSONObject, Unit> r100) {
        String r101 = this.metaParam;
        if (r101 == null) goto L11;
        JSONObject r102 = com.bytedance.android.shopping.anchorv3.a.d(r101);
        if (r102 == null) goto L12;
        JSONObject r103 = com.bytedance.android.shopping.anchorv3.a.d(r102.optString("market_address"));
        if (r103 != null) goto L9;
        r103 = new JSONObject();
    L9:
        r100.invoke(r103);
        r102.put("market_address", r103.toString());
        this.metaParam = r102.toString();
        return;
    L12:
        return;
    }

    public final void setAddressId(String r100) {
        this.addressId = r100;
    }

    public final void setCachedEcomScenedId(String r100) {
        this.cachedEcomScenedId = r100;
    }

    public final void setCachedRequestAdditionsJson(JSONObject r100) {
        this.cachedRequestAdditionsJson = r100;
    }

    public final void setCreativeId(String r100) {
        this.creativeId = r100;
    }

    public final void setDetailApiImagesConstraint(Map<String, String> r100) {
        this.detailApiImagesConstraint = r100;
    }

    public final void setFromVideo(Boolean r100) {
        this.isFromVideo = r100;
    }

    public final void setFullResp(Boolean r100) {
        this.fullResp = r100;
    }

    public final void setMetaParam(String r100) {
        this.metaParam = r100;
    }

    public final void setPackApiImagesConstraint(Map<String, String> r100) {
        this.packApiImagesConstraint = r100;
    }

    public final void setPerfOpt(boolean r100) {
        this.isPerfOpt = r100;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public final void setRefreshReqParams(String r100) {
        this.refreshReqParams = r100;
    }

    public final void setRoomId(String r100) {
        this.roomId = r100;
    }

    public final void setStoreRecommendApiImageConstraints(Map<String, String> r100) {
        this.storeRecommendApiImageConstraints = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public void updateAddressDetail(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "addressList");
        updateMarketAddress(new AnonymousClass1(r100));
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public void updateClientStorage(String r100) {
        V4ServerParams r101 = this.v4ServerParams;
        if (r101 == null) goto L6;
        r101.setClientStorageJStr(r100);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public void updateFullResp(boolean r100) {
        this.fullResp = Boolean.valueOf(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public void updateIsAuth(boolean r100) {
        V4ServerParams r101 = this.v4ServerParams;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        String r102 = "1";
    L7:
        r101.setAuth(r102);
        return;
    L6:
        r102 = "0";
        goto L7
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public void updateIsExpanded(boolean r100) {
        V4ServerParams r101 = this.v4ServerParams;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        String r102 = "1";
    L7:
        r101.setExpanded(r102);
        return;
    L6:
        r102 = "0";
        goto L7
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public void updateNormalSkuId(String r100) {
        V4ServerParams r101 = this.v4ServerParams;
        if (r101 == null) goto L5;
        r101.setNormalSkuId(r100);
    L5:
        V4ServerParams r102 = this.v4ServerParams;
        if (r102 != null) goto L8;
        return;
    L8:
        if (com.bytedance.android.shopping.anchorv3.a.b(r100) == false) goto L10;
        String r103 = "1";
    L11:
        r102.setSkuSwitch(r103);
        return;
    L10:
        r103 = "0";
        goto L11
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public void updateRefreshRepParams(String r100) {
        this.refreshReqParams = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public void updateSelectedIds(List<String> r100) {
        List<String> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L16;
        return;
    L16:
        V4ServerParams r103 = this.v4ServerParams;     // Catch: Exception -> L15
        if (r103 == null) goto L18;
        r103.setSelectedIds(new JSONArray(r100).toString());     // Catch: Exception -> L15
        return;
    L18:
        return;
    L19:
        return;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public void updateShopRecommendTabIndex(Integer r100) {
        if (r100 == null) goto L7;
        r100.intValue();
        V4ServerParams r101 = this.v4ServerParams;
        if (r101 == null) goto L8;
        r101.setShopRecommendTabIndex(r100);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public void updateSkuSwitch(String r100) {
        V4ServerParams r101 = this.v4ServerParams;     // Catch: Exception -> L10
        if (r101 != null) goto L5;
        return;
    L5:
        if (com.bytedance.android.shopping.anchorv3.a.b(r100) == false) goto L7;
        String r102 = "1";
    L8:
        r101.setSkuSwitch(r102);     // Catch: Exception -> L10
        return;
    L7:
        r102 = "0";
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public void updateAddressId(final String r100, final Integer r101) {
        this.addressId = r100;
        if (r100 == null) goto L8;
        if (r101 == null) goto L9;
        updateMarketAddress(new C102701(r100, r101));
        return;
    L9:
        return;
    }

    public AnchorV3PromotionRequestParam(List<String> r100, String r101, String r110, String r111, String r112, String r113, LubanParam r114, String r115, String r116, String r117, String r118, Integer r119, Integer r210, String r211, Integer r212, String r213, String r214, String r215, Boolean r216, Map<String, String> r217, Map<String, String> r218, Map<String, String> r219, String r310, String r311, V4ServerParams r312, Integer r313, Boolean r314, String r315, Integer r316, List<String> r317, boolean r318, JSONObject r319, String r410, boolean r411, boolean r412, List<String> r413, Integer r414, Integer r415, String r416, Boolean r417, String r418, String r419, String r510) {
        Intrinsics.checkNotNullParameter(r111, "secAuthorId");
        Intrinsics.checkNotNullParameter(r113, "sourcePage");
        Intrinsics.checkNotNullParameter(r115, "userId");
        Intrinsics.checkNotNullParameter(r116, "secUserId");
        Intrinsics.checkNotNullParameter(r410, "authorOpenId");
        super(null);
        this.promotionIds = r100;
        this.promotionId = r101;
        this.itemId = r110;
        this.secAuthorId = r111;
        this.metaParam = r112;
        this.sourcePage = r113;
        this.lubanParam = r114;
        this.userId = r115;
        this.secUserId = r116;
        this.requestAdditions = r117;
        this.authorId = r118;
        this.width = r119;
        this.height = r210;
        this.rankId = r211;
        this.internalFeedAB = r212;
        this.sourceType = r213;
        this.addressId = r214;
        this.roomId = r215;
        this.isFromVideo = r216;
        this.packApiImagesConstraint = r217;
        this.detailApiImagesConstraint = r218;
        this.storeRecommendApiImageConstraints = r219;
        this.productId = r310;
        this.creativeId = r311;
        this.v4ServerParams = r312;
        this.sameProductScene = r313;
        this.isPreload = r314;
        this.channelId = r315;
        this.channelType = r316;
        this.identifiers = r317;
        this.clientCacheDisable = r318;
        this.aggParams = r319;
        this.authorOpenId = r410;
        this.isStar = r411;
        this.isAds = r412;
        this.goodPriceParam = r413;
        this.goodPriceCardGuessLikeOpt = r414;
        this.goodPriceCardMainOpt = r415;
        this.bizCampaignType = r416;
        this.fullResp = r417;
        this.nGroupBuyToken = r418;
        this.ecomEntranceForm = r419;
        this.refreshReqParams = r510;
    }

    public /* synthetic */ AnchorV3PromotionRequestParam(List r410, String r411, String r412, String r413, String r414, String r415, LubanParam r416, String r510, String r511, String r512, String r513, Integer r514, Integer r515, String r516, Integer r517, String r518, String r519, String r610, Boolean r611, Map r612, Map r613, Map r614, String r615, String r616, V4ServerParams r617, Integer r618, Boolean r619, String r710, Integer r711, List r712, boolean r713, JSONObject r714, String r715, boolean r716, boolean r717, List r718, Integer r719, Integer r810, String r811, Boolean r812, String r813, String r814, String r815, int r816, int r817, DefaultConstructorMarker r818) {
        if ((r816 & 1) == 0) goto L5;
        List r100 = null;
    L7:
        if ((r816 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r816 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r816 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r816 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r816 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r816 & 64) == 0) goto L29;
        LubanParam r110 = null;
    L31:
        if ((r816 & 128) == 0) goto L33;
        String r111 = "";
    L35:
        if ((r816 & 256) == 0) goto L37;
        String r112 = "";
    L39:
        if ((r816 & 512) == 0) goto L41;
        String r113 = null;
    L43:
        if ((r816 & 1024) == 0) goto L45;
        String r114 = null;
    L47:
        if ((r816 & 2048) == 0) goto L49;
        Integer r115 = null;
    L51:
        if ((r816 & 4096) == 0) goto L53;
        Integer r106 = null;
    L55:
        if ((r816 & 8192) == 0) goto L57;
        String r107 = null;
    L58:
        String r116 = r107;
        if ((r816 & 16384) == 0) goto L61;
        Integer r108 = null;
    L63:
        if ((r816 & 32768) == 0) goto L65;
        String r117 = null;
    L67:
        if ((r816 & 65536) == 0) goto L69;
        String r118 = null;
    L71:
        if ((r816 & 131072) == 0) goto L73;
        String r119 = null;
    L75:
        if ((r816 & 262144) == 0) goto L77;
        Boolean r210 = null;
    L79:
        if ((r816 & 524288) == 0) goto L81;
        Map r211 = null;
    L83:
        if ((r816 & 1048576) == 0) goto L85;
        Map r212 = null;
    L87:
        if ((r816 & 2097152) == 0) goto L89;
        Map r213 = null;
    L91:
        if ((r816 & 4194304) == 0) goto L93;
        String r214 = null;
    L95:
        if ((r816 & 8388608) == 0) goto L97;
        String r215 = null;
    L99:
        if ((r816 & 16777216) == 0) goto L101;
        V4ServerParams r216 = null;
    L103:
        if ((r816 & 33554432) == 0) goto L105;
        Integer r217 = 0;
    L107:
        if ((r816 & 67108864) == 0) goto L109;
        Boolean r218 = Boolean.FALSE;
    L111:
        if ((r816 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        String r310 = null;
    L115:
        if ((r816 & 268435456) == 0) goto L117;
        Integer r311 = 0;
    L119:
        if ((r816 & 536870912) == 0) goto L121;
        List r312 = null;
    L123:
        if ((r816 & 1073741824) == 0) goto L125;
        boolean r313 = false;
    L127:
        if ((r816 & Integer.MIN_VALUE) == 0) goto L129;
        JSONObject r109 = null;
    L131:
        if ((r817 & 1) == 0) goto L133;
        String r314 = "";
    L135:
        if ((r817 & 2) == 0) goto L137;
        boolean r315 = false;
    L139:
        if ((r817 & 4) == 0) goto L141;
        boolean r316 = false;
    L143:
        if ((r817 & 8) == 0) goto L145;
        List r317 = null;
    L147:
        if ((r817 & 16) == 0) goto L149;
        Integer r318 = 0;
    L151:
        if ((r817 & 32) == 0) goto L153;
        Integer r219 = 0;
    L155:
        if ((r817 & 64) == 0) goto L157;
        String r319 = null;
    L158:
        JSONObject r819 = r109;
        if ((r817 & 128) == 0) goto L161;
        Boolean r120 = null;
    L162:
        Boolean r417 = r120;
        if ((r817 & 256) == 0) goto L165;
        String r121 = null;
    L166:
        String r418 = r121;
        if ((r817 & 512) == 0) goto L169;
        String r122 = null;
    L171:
        if ((r817 & 1024) == 0) goto L173;
        String r123 = null;
    L174:
        this(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r116, r108, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r819, r314, r315, r316, r317, r318, r219, r319, r417, r418, r122, r123);
        return;
    L173:
        r123 = r815;
        goto L174
    L169:
        r122 = r814;
        goto L171
    L165:
        r121 = r813;
        goto L166
    L161:
        r120 = r812;
        goto L162
    L157:
        r319 = r811;
        goto L158
    L153:
        r219 = r810;
        goto L155
    L149:
        r318 = r719;
        goto L151
    L145:
        r317 = r718;
        goto L147
    L141:
        r316 = r717;
        goto L143
    L137:
        r315 = r716;
        goto L139
    L133:
        r314 = r715;
        goto L135
    L129:
        r109 = r714;
        goto L131
    L125:
        r313 = r713;
        goto L127
    L121:
        r312 = r712;
        goto L123
    L117:
        r311 = r711;
        goto L119
    L113:
        r310 = r710;
        goto L115
    L109:
        r218 = r619;
        goto L111
    L105:
        r217 = r618;
        goto L107
    L101:
        r216 = r617;
        goto L103
    L97:
        r215 = r616;
        goto L99
    L93:
        r214 = r615;
        goto L95
    L89:
        r213 = r614;
        goto L91
    L85:
        r212 = r613;
        goto L87
    L81:
        r211 = r612;
        goto L83
    L77:
        r210 = r611;
        goto L79
    L73:
        r119 = r610;
        goto L75
    L69:
        r118 = r519;
        goto L71
    L65:
        r117 = r518;
        goto L67
    L61:
        r108 = r517;
        goto L63
    L57:
        r107 = r516;
        goto L58
    L53:
        r106 = r515;
        goto L55
    L49:
        r115 = r514;
        goto L51
    L45:
        r114 = r513;
        goto L47
    L41:
        r113 = r512;
        goto L43
    L37:
        r112 = r511;
        goto L39
    L33:
        r111 = r510;
        goto L35
    L29:
        r110 = r416;
        goto L31
    L25:
        r105 = r415;
        goto L27
    L21:
        r104 = r414;
        goto L23
    L17:
        r103 = r413;
        goto L19
    L13:
        r102 = r412;
        goto L15
    L9:
        r101 = r411;
        goto L11
    L5:
        r100 = r410;
        goto L7
    }
}
