package com.bytedance.android.shopping.anchorv4.bottom;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECBoltParam;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionDepositPresaleActivity;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMetaMappedMap;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0003\b´\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B³\b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010%\u001a\u00020\u000b\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010'\u001a\u00020\u000b\u0012\b\b\u0002\u0010(\u001a\u00020\u000b\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010+\u001a\u00020,\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010/\u001a\u00020\u001a\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000105\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010:\u001a\u00020\u001a\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010=\u001a\u00020\u000b\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010A\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010H\u0012\b\b\u0002\u0010I\u001a\u00020\u000b\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0003\u0012\u001e\b\u0002\u0010K\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010M\u0018\u00010Lj\u0004\u0018\u0001`N\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010U\u001a\u00020\u000b\u0012\b\b\u0002\u0010V\u001a\u00020,\u0012\b\b\u0002\u0010W\u001a\u00020,\u0012\b\b\u0002\u0010X\u001a\u00020,\u0012\b\b\u0002\u0010Y\u001a\u00020\u000b\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010^\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010_\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010b\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010c\u0012\u0012\b\u0002\u0010d\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010c\u0012\u0012\b\u0002\u0010e\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010c\u0012\u0012\b\u0002\u0010f\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010c¢\u0006\u0002\u0010gJ\u001b\u0010\u0093\u0002\u001a\u0004\u0018\u00010\u00032\u0007\u0010\u0094\u0002\u001a\u00020\u000b2\u0007\u0010\u0095\u0002\u001a\u00020\u000bJ\u0013\u0010\u0096\u0002\u001a\u00020\u00002\n\u0010\u0097\u0002\u001a\u0005\u0018\u00010\u0098\u0002J%\u0010\u0099\u0002\u001a\u0005\u0018\u00010\u009a\u00022\u0007\u0010\u009b\u0002\u001a\u00020\u000b2\u0007\u0010\u0094\u0002\u001a\u00020\u000b2\u0007\u0010\u0095\u0002\u001a\u00020\u000bR\u001c\u0010>\u001a\u0004\u0018\u00010?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u001a\u0010/\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001c\u0010.\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u001c\u00108\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010u\"\u0004\by\u0010wR\u001c\u0010!\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010u\"\u0004\b{\u0010wR\u001c\u00100\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010u\"\u0004\b}\u0010wR\u0018\u0010`\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b~\u0010uR\u001f\u0010@\u001a\u0004\u0018\u00010AX\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010u\"\u0005\b\u0084\u0001\u0010wR\u001e\u0010$\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010u\"\u0005\b\u0086\u0001\u0010wR\u001e\u00101\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010u\"\u0005\b\u0088\u0001\u0010wR\u0019\u0010Q\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0089\u0001\u0010uR\"\u0010[\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010u\"\u0005\b\u008b\u0001\u0010wR'\u0010\\\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0003\u0010\u0090\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001e\u0010\"\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010u\"\u0005\b\u0092\u0001\u0010wR\"\u0010]\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010u\"\u0005\b\u0094\u0001\u0010wR\u0019\u0010T\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0095\u0001\u0010uR,\u0010^\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010_8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009a\u0001\u0010u\"\u0005\b\u009b\u0001\u0010wR \u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b \u0001\u0010u\"\u0005\b¡\u0001\u0010wR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0001\u0010u\"\u0005\b£\u0001\u0010wR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¤\u0001\u0010u\"\u0005\b¥\u0001\u0010wR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¦\u0001\u0010u\"\u0005\b§\u0001\u0010wR\u001a\u0010G\u001a\u0004\u0018\u00010H8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b¨\u0001\u0010©\u0001R\u001c\u0010:\u001a\u00020\u001aX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bª\u0001\u0010q\"\u0005\b«\u0001\u0010sR\u001e\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¬\u0001\u0010\u00ad\u0001\"\u0006\b®\u0001\u0010¯\u0001R\u001e\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b°\u0001\u0010\u00ad\u0001\"\u0006\b±\u0001\u0010¯\u0001R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b²\u0001\u0010uR\u0019\u0010S\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b³\u0001\u0010uR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b´\u0001\u0010u\"\u0005\bµ\u0001\u0010wR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¶\u0001\u0010u\"\u0005\b·\u0001\u0010wR\u0018\u0010U\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b¸\u0001\u0010\u00ad\u0001R\u001e\u00103\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¹\u0001\u0010u\"\u0005\bº\u0001\u0010wR\u001e\u00102\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b»\u0001\u0010u\"\u0005\b¼\u0001\u0010wR\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u0015\u0010u\"\u0005\b½\u0001\u0010wR\u001d\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0013\u0010\u00ad\u0001\"\u0006\b¾\u0001\u0010¯\u0001R\u001d\u0010=\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b=\u0010\u00ad\u0001\"\u0006\b¿\u0001\u0010¯\u0001R\u001d\u0010(\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b(\u0010\u00ad\u0001\"\u0006\bÀ\u0001\u0010¯\u0001R\u001e\u00107\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÁ\u0001\u0010u\"\u0005\bÂ\u0001\u0010wR\u001e\u0010<\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÃ\u0001\u0010u\"\u0005\bÄ\u0001\u0010wR\u001e\u0010D\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÅ\u0001\u0010u\"\u0005\bÆ\u0001\u0010wR\u001e\u0010C\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÇ\u0001\u0010u\"\u0005\bÈ\u0001\u0010wR\u001e\u00106\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÉ\u0001\u0010u\"\u0005\bÊ\u0001\u0010wR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bË\u0001\u0010u\"\u0005\bÌ\u0001\u0010wR\u001e\u0010F\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÍ\u0001\u0010u\"\u0005\bÎ\u0001\u0010wR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÏ\u0001\u0010u\"\u0005\bÐ\u0001\u0010wR\u0019\u0010a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\bÑ\u0001\u0010uR\u0019\u0010R\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\bÒ\u0001\u0010uR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÓ\u0001\u0010u\"\u0005\bÔ\u0001\u0010wR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÕ\u0001\u0010u\"\u0005\bÖ\u0001\u0010wR\u001e\u0010B\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b×\u0001\u0010u\"\u0005\bØ\u0001\u0010wR\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÙ\u0001\u0010u\"\u0005\bÚ\u0001\u0010wR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÛ\u0001\u0010u\"\u0005\bÜ\u0001\u0010wR\u001c\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÝ\u0001\u0010q\"\u0005\bÞ\u0001\u0010sR\u001e\u0010)\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bß\u0001\u0010u\"\u0005\bà\u0001\u0010wR\u0019\u0010J\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\bá\u0001\u0010uR\u001e\u0010*\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bâ\u0001\u0010u\"\u0005\bã\u0001\u0010wR\u001e\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bä\u0001\u0010å\u0001\"\u0006\bæ\u0001\u0010ç\u0001R\u001e\u0010 \u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bè\u0001\u0010u\"\u0005\bé\u0001\u0010wR\u0019\u0010P\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\bê\u0001\u0010uR\u0019\u0010O\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\bë\u0001\u0010uR\u001e\u0010&\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bì\u0001\u0010u\"\u0005\bí\u0001\u0010wR\u0018\u0010Y\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\bî\u0001\u0010\u00ad\u0001R\u0018\u0010V\u001a\u00020,8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\bï\u0001\u0010å\u0001R\u0018\u0010W\u001a\u00020,8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\bð\u0001\u0010å\u0001R\u0018\u0010X\u001a\u00020,8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\bñ\u0001\u0010å\u0001R\u001e\u00109\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bò\u0001\u0010u\"\u0005\bó\u0001\u0010wR\u0019\u0010Z\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\bô\u0001\u0010uR\u0018\u0010I\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\bõ\u0001\u0010\u00ad\u0001R\u001e\u0010-\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bö\u0001\u0010u\"\u0005\b÷\u0001\u0010wR\u001e\u0010%\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bø\u0001\u0010\u00ad\u0001\"\u0006\bù\u0001\u0010¯\u0001R\"\u0010b\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010c8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\bú\u0001\u0010û\u0001R\"\u0010f\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010c8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\bü\u0001\u0010û\u0001R\"\u0010e\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010c8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\bý\u0001\u0010û\u0001R\"\u0010d\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010c8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\bþ\u0001\u0010û\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÿ\u0001\u0010u\"\u0005\b\u0080\u0002\u0010wR\u001e\u0010'\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0081\u0002\u0010\u00ad\u0001\"\u0006\b\u0082\u0002\u0010¯\u0001R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0002\u0010u\"\u0005\b\u0084\u0002\u0010wR\u001e\u0010E\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0002\u0010u\"\u0005\b\u0086\u0002\u0010wR.\u0010K\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010M\u0018\u00010Lj\u0004\u0018\u0001`N8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0087\u0002\u0010\u0088\u0002R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0002\u0010u\"\u0005\b\u008a\u0002\u0010wR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0002\u0010u\"\u0005\b\u008c\u0002\u0010wR\u001e\u0010;\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0002\u0010u\"\u0005\b\u008e\u0002\u0010wR\u001e\u0010#\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0002\u0010u\"\u0005\b\u0090\u0002\u0010wR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0002\u0010u\"\u0005\b\u0092\u0002\u0010w¨\u0006\u009c\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/bottom/SkuMeta;", "Ljava/io/Serializable;", "transmissibleJson", "", "sourcePage", "enterMethod", "entranceInfo", "metaParam", "v3EventsAdditions", "eComEntranceFrom", "fromLive", "", "fromVideo", "passThroughEventData", "enterFrom", "groupId", "originType", "originId", "brandVerified", "isCrossBorderProduct", "goodsType", "isAuthenticInsure", "hasReplay", "withVideo", "threeDLogData", "preSellType", "", "preSellDelayDes", "deliveryDelayDes", "logData", "depositPreSaleActivity", "Lcom/bytedance/android/ec/model/PromotionDepositPresaleActivity;", "rebateId", "avlDiscount", "couponId", "withSku", "campaignType", "showInstallmentFlag", "requestAdditions", "thirdParty", "isVirtual", "productId", "promotionId", "promotionSource", "", "shopId", "applyCouponIds", "applyCoupon", "baseVerifiedCategory", "cardStatus", "hotSaleType", "hotSaleSkuId", "addCartMeta", "Lcom/bytedance/android/shopping/anchorv4/bottom/AddCartMeta;", "liveRoomId", "itemId", "authorId", "secAuthorId", "followStatus", "whichAccount", "kolUserTags", "isLuban", "adLogExtra", "Lcom/bytedance/android/ec/model/ECAdLogExtra;", "boltParam", "Lcom/bytedance/android/ec/model/ECBoltParam;", "pageId", "labelNameLive", "labelName", "trackExtra", "marketingChannel", "firstImage", "Lcom/bytedance/android/ec/model/ECUrlModel;", "setCartGray", "productTypeVerified", "trackMeta", "Lcom/google/gson/internal/LinkedTreeMap;", "", "Lcom/bytedance/android/shopping/anchorv4/dto/meta/TrackMeta;", "recommendInfo", "receiveAddressId", "cashRebate", "orderUrl", "groupBuyOrderUrl", "customBuyOrderUrl", "hasSecActivity", "secActivityBeginTime", "secActivityEndTime", "secActivityServerTime", "scrollToDouInstallment", "selectedCarId", RemoteMessageConst.Notification.CHANNEL_ID, "channelType", "cpsTrack", "defaultSpecIds", "", "bizCampaignType", "nGroupBuyToken", "skuAddCartAction", "", "skuGroupBuyAction", "skuCustomBuyAction", "skuBuyAction", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/PromotionDepositPresaleActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZZLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/bottom/AddCartMeta;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZLcom/bytedance/android/ec/model/ECAdLogExtra;Lcom/bytedance/android/ec/model/ECBoltParam;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;ZLjava/lang/String;Lcom/google/gson/internal/LinkedTreeMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJJJZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getAdLogExtra", "()Lcom/bytedance/android/ec/model/ECAdLogExtra;", "setAdLogExtra", "(Lcom/bytedance/android/ec/model/ECAdLogExtra;)V", "getAddCartMeta", "()Lcom/bytedance/android/shopping/anchorv4/bottom/AddCartMeta;", "setAddCartMeta", "(Lcom/bytedance/android/shopping/anchorv4/bottom/AddCartMeta;)V", "getApplyCoupon", "()I", "setApplyCoupon", "(I)V", "getApplyCouponIds", "()Ljava/lang/String;", "setApplyCouponIds", "(Ljava/lang/String;)V", "getAuthorId", "setAuthorId", "getAvlDiscount", "setAvlDiscount", "getBaseVerifiedCategory", "setBaseVerifiedCategory", "getBizCampaignType", "getBoltParam", "()Lcom/bytedance/android/ec/model/ECBoltParam;", "setBoltParam", "(Lcom/bytedance/android/ec/model/ECBoltParam;)V", "getBrandVerified", "setBrandVerified", "getCampaignType", "setCampaignType", "getCardStatus", "setCardStatus", "getCashRebate", "getChannelId", "setChannelId", "getChannelType", "()Ljava/lang/Integer;", "setChannelType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCouponId", "setCouponId", "getCpsTrack", "setCpsTrack", "getCustomBuyOrderUrl", "getDefaultSpecIds", "()Ljava/util/List;", "setDefaultSpecIds", "(Ljava/util/List;)V", "getDeliveryDelayDes", "setDeliveryDelayDes", "getDepositPreSaleActivity", "()Lcom/bytedance/android/ec/model/PromotionDepositPresaleActivity;", "setDepositPreSaleActivity", "(Lcom/bytedance/android/ec/model/PromotionDepositPresaleActivity;)V", "getEComEntranceFrom", "setEComEntranceFrom", "getEnterFrom", "setEnterFrom", "getEnterMethod", "setEnterMethod", "getEntranceInfo", "setEntranceInfo", "getFirstImage", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getFollowStatus", "setFollowStatus", "getFromLive", "()Z", "setFromLive", "(Z)V", "getFromVideo", "setFromVideo", "getGoodsType", "getGroupBuyOrderUrl", "getGroupId", "setGroupId", "getHasReplay", "setHasReplay", "getHasSecActivity", "getHotSaleSkuId", "setHotSaleSkuId", "getHotSaleType", "setHotSaleType", "setAuthenticInsure", "setCrossBorderProduct", "setLuban", "setVirtual", "getItemId", "setItemId", "getKolUserTags", "setKolUserTags", "getLabelName", "setLabelName", "getLabelNameLive", "setLabelNameLive", "getLiveRoomId", "setLiveRoomId", "getLogData", "setLogData", "getMarketingChannel", "setMarketingChannel", "getMetaParam", "setMetaParam", "getNGroupBuyToken", "getOrderUrl", "getOriginId", "setOriginId", "getOriginType", "setOriginType", "getPageId", "setPageId", "getPassThroughEventData", "setPassThroughEventData", "getPreSellDelayDes", "setPreSellDelayDes", "getPreSellType", "setPreSellType", "getProductId", "setProductId", "getProductTypeVerified", "getPromotionId", "setPromotionId", "getPromotionSource", "()J", "setPromotionSource", "(J)V", "getRebateId", "setRebateId", "getReceiveAddressId", "getRecommendInfo", "getRequestAdditions", "setRequestAdditions", "getScrollToDouInstallment", "getSecActivityBeginTime", "getSecActivityEndTime", "getSecActivityServerTime", "getSecAuthorId", "setSecAuthorId", "getSelectedCarId", "getSetCartGray", "getShopId", "setShopId", "getShowInstallmentFlag", "setShowInstallmentFlag", "getSkuAddCartAction", "()Ljava/util/Map;", "getSkuBuyAction", "getSkuCustomBuyAction", "getSkuGroupBuyAction", "getSourcePage", "setSourcePage", "getThirdParty", "setThirdParty", "getThreeDLogData", "setThreeDLogData", "getTrackExtra", "setTrackExtra", "getTrackMeta", "()Lcom/google/gson/internal/LinkedTreeMap;", "getTransmissibleJson", "setTransmissibleJson", "getV3EventsAdditions", "setV3EventsAdditions", "getWhichAccount", "setWhichAccount", "getWithSku", "setWithSku", "getWithVideo", "setWithVideo", "chooseTheRightOrderUrl", "isGroupBuying", "isCustomBuying", "fillCommonMeta", "commonMeta", "Lcom/bytedance/android/shopping/anchorv4/dto/meta/CommonMeta;", "getSchemaSkuAction", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "isAddToCart", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuMeta implements Serializable {
    private ECAdLogExtra adLogExtra;
    private AddCartMeta addCartMeta;
    private int applyCoupon;
    private String applyCouponIds;
    private String authorId;
    private String avlDiscount;
    private String baseVerifiedCategory;

    @SerializedName("biz_campaign_type")
    private final String bizCampaignType;
    private ECBoltParam boltParam;
    private String brandVerified;
    private String campaignType;
    private String cardStatus;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CASH_REBATE)
    private final String cashRebate;

    @SerializedName("channel_id")
    private String channelId;

    @SerializedName(WsConstants.KEY_CHANNEL_TYPE)
    private Integer channelType;
    private String couponId;

    @SerializedName("cps_track")
    private String cpsTrack;

    @SerializedName("custom_buy_order_url")
    private final String customBuyOrderUrl;

    @SerializedName("default_spec_ids")
    private List<String> defaultSpecIds;
    private String deliveryDelayDes;
    private PromotionDepositPresaleActivity depositPreSaleActivity;
    private String eComEntranceFrom;
    private String enterFrom;
    private String enterMethod;
    private String entranceInfo;

    @SerializedName("first_image")
    private final ECUrlModel firstImage;
    private int followStatus;
    private boolean fromLive;
    private boolean fromVideo;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_GOODS_TYPE)
    private final String goodsType;

    @SerializedName("group_buy_order_url")
    private final String groupBuyOrderUrl;
    private String groupId;
    private String hasReplay;

    @SerializedName("has_sec_activity")
    private final boolean hasSecActivity;
    private String hotSaleSkuId;
    private String hotSaleType;
    private String isAuthenticInsure;
    private boolean isCrossBorderProduct;
    private boolean isLuban;
    private boolean isVirtual;
    private String itemId;
    private String kolUserTags;
    private String labelName;
    private String labelNameLive;
    private String liveRoomId;
    private String logData;
    private String marketingChannel;
    private String metaParam;

    @SerializedName("ngroup_buy_token")
    private final String nGroupBuyToken;

    @SerializedName("order_url")
    private final String orderUrl;
    private String originId;
    private String originType;
    private String pageId;
    private String passThroughEventData;
    private String preSellDelayDes;
    private int preSellType;
    private String productId;

    @SerializedName("product_type_verified")
    private final String productTypeVerified;
    private String promotionId;
    private long promotionSource;
    private String rebateId;

    @SerializedName("receive_address_id")
    private final String receiveAddressId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO)
    private final String recommendInfo;
    private String requestAdditions;

    @SerializedName("scroll_to_dou_installment")
    private final boolean scrollToDouInstallment;

    @SerializedName("sec_activity_begin_time")
    private final long secActivityBeginTime;

    @SerializedName("sec_activity_end_time")
    private final long secActivityEndTime;

    @SerializedName("sec_activity_server_time")
    private final long secActivityServerTime;
    private String secAuthorId;

    @SerializedName("selected_car_id")
    private final String selectedCarId;

    @SerializedName("set_cart_gray")
    private final boolean setCartGray;
    private String shopId;
    private boolean showInstallmentFlag;

    @SerializedName("sku_add_cart_action")
    private final Map<?, ?> skuAddCartAction;

    @SerializedName("sku_buy_action")
    private final Map<?, ?> skuBuyAction;

    @SerializedName("sku_custombuy_action")
    private final Map<?, ?> skuCustomBuyAction;

    @SerializedName("sku_groupbuy_action")
    private final Map<?, ?> skuGroupBuyAction;
    private String sourcePage;
    private boolean thirdParty;
    private String threeDLogData;
    private String trackExtra;

    @SerializedName(PageMetaMappedMap.TRACK_META_KEY)
    private final LinkedTreeMap<String, Object> trackMeta;
    private String transmissibleJson;
    private String v3EventsAdditions;
    private String whichAccount;
    private String withSku;
    private String withVideo;

    public SkuMeta() {
        this(null, null, null, null, null, null, null, false, false, null, null, null, null, null, null, false, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, false, false, null, null, 0, null, null, 0, null, null, null, null, null, null, null, null, null, 0, null, null, false, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, false, 0, 0, 0, false, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 8388607, null);
    }

    public final ECAdLogExtra getAdLogExtra() {
        return this.adLogExtra;
    }

    public final AddCartMeta getAddCartMeta() {
        return this.addCartMeta;
    }

    public final int getApplyCoupon() {
        return this.applyCoupon;
    }

    public final String getApplyCouponIds() {
        return this.applyCouponIds;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getAvlDiscount() {
        return this.avlDiscount;
    }

    public final String getBaseVerifiedCategory() {
        return this.baseVerifiedCategory;
    }

    public final String getBizCampaignType() {
        return this.bizCampaignType;
    }

    public final ECBoltParam getBoltParam() {
        return this.boltParam;
    }

    public final String getBrandVerified() {
        return this.brandVerified;
    }

    public final String getCampaignType() {
        return this.campaignType;
    }

    public final String getCardStatus() {
        return this.cardStatus;
    }

    public final String getCashRebate() {
        return this.cashRebate;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final Integer getChannelType() {
        return this.channelType;
    }

    public final String getCouponId() {
        return this.couponId;
    }

    public final String getCpsTrack() {
        return this.cpsTrack;
    }

    public final String getCustomBuyOrderUrl() {
        return this.customBuyOrderUrl;
    }

    public final List<String> getDefaultSpecIds() {
        return this.defaultSpecIds;
    }

    public final String getDeliveryDelayDes() {
        return this.deliveryDelayDes;
    }

    public final PromotionDepositPresaleActivity getDepositPreSaleActivity() {
        return this.depositPreSaleActivity;
    }

    public final String getEComEntranceFrom() {
        return this.eComEntranceFrom;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final ECUrlModel getFirstImage() {
        return this.firstImage;
    }

    public final int getFollowStatus() {
        return this.followStatus;
    }

    public final boolean getFromLive() {
        return this.fromLive;
    }

    public final boolean getFromVideo() {
        return this.fromVideo;
    }

    public final String getGoodsType() {
        return this.goodsType;
    }

    public final String getGroupBuyOrderUrl() {
        return this.groupBuyOrderUrl;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getHasReplay() {
        return this.hasReplay;
    }

    public final boolean getHasSecActivity() {
        return this.hasSecActivity;
    }

    public final String getHotSaleSkuId() {
        return this.hotSaleSkuId;
    }

    public final String getHotSaleType() {
        return this.hotSaleType;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getKolUserTags() {
        return this.kolUserTags;
    }

    public final String getLabelName() {
        return this.labelName;
    }

    public final String getLabelNameLive() {
        return this.labelNameLive;
    }

    public final String getLiveRoomId() {
        return this.liveRoomId;
    }

    public final String getLogData() {
        return this.logData;
    }

    public final String getMarketingChannel() {
        return this.marketingChannel;
    }

    public final String getMetaParam() {
        return this.metaParam;
    }

    public final String getNGroupBuyToken() {
        return this.nGroupBuyToken;
    }

    public final String getOrderUrl() {
        return this.orderUrl;
    }

    public final String getOriginId() {
        return this.originId;
    }

    public final String getOriginType() {
        return this.originType;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final String getPassThroughEventData() {
        return this.passThroughEventData;
    }

    public final String getPreSellDelayDes() {
        return this.preSellDelayDes;
    }

    public final int getPreSellType() {
        return this.preSellType;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getProductTypeVerified() {
        return this.productTypeVerified;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final long getPromotionSource() {
        return this.promotionSource;
    }

    public final String getRebateId() {
        return this.rebateId;
    }

    public final String getReceiveAddressId() {
        return this.receiveAddressId;
    }

    public final String getRecommendInfo() {
        return this.recommendInfo;
    }

    public final String getRequestAdditions() {
        return this.requestAdditions;
    }

    public final boolean getScrollToDouInstallment() {
        return this.scrollToDouInstallment;
    }

    public final long getSecActivityBeginTime() {
        return this.secActivityBeginTime;
    }

    public final long getSecActivityEndTime() {
        return this.secActivityEndTime;
    }

    public final long getSecActivityServerTime() {
        return this.secActivityServerTime;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final String getSelectedCarId() {
        return this.selectedCarId;
    }

    public final boolean getSetCartGray() {
        return this.setCartGray;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final boolean getShowInstallmentFlag() {
        return this.showInstallmentFlag;
    }

    public final Map<?, ?> getSkuAddCartAction() {
        return this.skuAddCartAction;
    }

    public final Map<?, ?> getSkuBuyAction() {
        return this.skuBuyAction;
    }

    public final Map<?, ?> getSkuCustomBuyAction() {
        return this.skuCustomBuyAction;
    }

    public final Map<?, ?> getSkuGroupBuyAction() {
        return this.skuGroupBuyAction;
    }

    public final String getSourcePage() {
        return this.sourcePage;
    }

    public final boolean getThirdParty() {
        return this.thirdParty;
    }

    public final String getThreeDLogData() {
        return this.threeDLogData;
    }

    public final String getTrackExtra() {
        return this.trackExtra;
    }

    public final LinkedTreeMap<String, Object> getTrackMeta() {
        return this.trackMeta;
    }

    public final String getTransmissibleJson() {
        return this.transmissibleJson;
    }

    public final String getV3EventsAdditions() {
        return this.v3EventsAdditions;
    }

    public final String getWhichAccount() {
        return this.whichAccount;
    }

    public final String getWithSku() {
        return this.withSku;
    }

    public final String getWithVideo() {
        return this.withVideo;
    }

    public final String isAuthenticInsure() {
        return this.isAuthenticInsure;
    }

    public final boolean isCrossBorderProduct() {
        return this.isCrossBorderProduct;
    }

    public final boolean isLuban() {
        return this.isLuban;
    }

    public final boolean isVirtual() {
        return this.isVirtual;
    }

    public final SkuMeta fillCommonMeta(CommonMeta r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getTransmissibleJson();
    L6:
        this.transmissibleJson = r102;
        if (r100 == null) goto L9;
        String r103 = r100.getSourcePage();
    L10:
        this.sourcePage = r103;
        if (r100 == null) goto L13;
        String r104 = r100.getEnterMethod();
    L14:
        this.enterMethod = r104;
        if (r100 == null) goto L17;
        String r105 = r100.getEntranceInfo();
    L18:
        if (r105 != null) goto L20;
        r105 = "";
    L20:
        this.entranceInfo = r105;
        if (r100 == null) goto L23;
        String r106 = r100.getMetaParam();
    L24:
        this.metaParam = r106;
        if (r100 == null) goto L27;
        String r107 = r100.getV3EventsAdditions();
    L28:
        this.v3EventsAdditions = r107;
        if (r100 == null) goto L31;
        String r108 = r100.getEComEntranceForm();
    L32:
        this.eComEntranceFrom = r108;
        if (r100 == null) goto L35;
        Boolean r109 = Boolean.valueOf(r100.getFromLive());
    L36:
        this.fromLive = com.bytedance.android.shopping.extensions.k.i(r109);
        if (r100 == null) goto L39;
        Boolean r110 = Boolean.valueOf(r100.getFromVideo());
    L40:
        this.fromVideo = com.bytedance.android.shopping.extensions.k.i(r110);
        if (r100 == null) goto L43;
        String r111 = r100.getTransitionTrackerData();
    L44:
        this.passThroughEventData = r111;
        if (r100 == null) goto L47;
        String r112 = r100.getMarketingChannel();
    L48:
        this.marketingChannel = r112;
        if (r100 == null) goto L51;
        String r113 = r100.getRequestAdditions();
    L52:
        JSONObject r114 = com.bytedance.android.shopping.extensions.k.w(r113);
        if (r114 == null) goto L55;
        String r115 = r114.optString("enter_from");
    L56:
        String r116 = a2.d(r115);
        if (r116 != null) goto L61;
        if (r100 == null) goto L60;
        r116 = r100.getSourcePage();
        goto L61
    L60:
        r116 = null;
    L61:
        this.enterFrom = r116;
        if (r100 == null) goto L64;
        String r117 = r100.getGroupId();
    L65:
        this.groupId = r117;
        if (r100 == null) goto L68;
        String r118 = r100.getOriginType();
    L69:
        this.originType = r118;
        if (r100 == null) goto L72;
        String r119 = r100.getOriginId();
    L73:
        this.originId = r119;
        if (r100 == null) goto L76;
        String r120 = r100.getBrandVerified();
    L77:
        this.brandVerified = r120;
        if (r100 == null) goto L80;
        Boolean r121 = Boolean.valueOf(r100.isCrossBorderProduct());
    L81:
        this.isCrossBorderProduct = com.bytedance.android.shopping.extensions.k.i(r121);
        if (r100 == null) goto L84;
        String r122 = r100.isAuthenticInsure();
    L85:
        this.isAuthenticInsure = r122;
        if (r100 == null) goto L88;
        String r123 = r100.getHasReplay();
    L89:
        this.hasReplay = r123;
        if (r100 == null) goto L92;
        String r124 = r100.getWithVideo();
    L93:
        this.withVideo = r124;
        if (r100 == null) goto L96;
        String r125 = r100.getThreeDLogData();
    L97:
        this.threeDLogData = r125;
        if (r100 == null) goto L100;
        Integer r126 = Integer.valueOf(r100.getPreSellType());
    L101:
        this.preSellType = com.bytedance.android.shopping.extensions.k.f(r126);
        if (r100 == null) goto L104;
        String r127 = r100.getPreSellDelayDes();
    L105:
        this.preSellDelayDes = r127;
        if (r100 == null) goto L108;
        String r128 = r100.getDeliveryDelayDes();
    L109:
        this.deliveryDelayDes = r128;
        if (r100 == null) goto L112;
        String r129 = r100.getLogData();
    L113:
        this.logData = r129;
        if (r100 == null) goto L116;
        PromotionDepositPresaleActivity r130 = r100.getDepositPreSaleActivity();
    L117:
        this.depositPreSaleActivity = r130;
        if (r100 == null) goto L120;
        String r131 = r100.getRebateId();
    L121:
        this.rebateId = r131;
        if (r100 == null) goto L124;
        String r132 = r100.getAvlDiscount();
    L125:
        this.avlDiscount = r132;
        if (r100 == null) goto L128;
        String r133 = r100.getCouponId();
    L129:
        this.couponId = r133;
        if (r100 == null) goto L132;
        String r134 = r100.getWithSku();
    L133:
        this.withSku = r134;
        if (r100 == null) goto L136;
        String r135 = r100.getCampaignType();
    L137:
        this.campaignType = r135;
        if (r100 == null) goto L140;
        Boolean r136 = Boolean.valueOf(r100.getShowInstallmentFlag());
    L141:
        this.showInstallmentFlag = com.bytedance.android.shopping.extensions.k.i(r136);
        if (r100 == null) goto L144;
        String r137 = r100.getRequestAdditions();
    L145:
        this.requestAdditions = r137;
        if (r100 == null) goto L148;
        Boolean r138 = Boolean.valueOf(r100.getThirdParty());
    L149:
        this.thirdParty = com.bytedance.android.shopping.extensions.k.i(r138);
        if (r100 == null) goto L152;
        Boolean r139 = Boolean.valueOf(r100.isVirtual());
    L153:
        this.isVirtual = com.bytedance.android.shopping.extensions.k.i(r139);
        if (r100 == null) goto L156;
        String r140 = r100.getProductId();
    L157:
        this.productId = r140;
        if (r100 == null) goto L160;
        String r141 = r100.getPromotionId();
    L161:
        this.promotionId = r141;
        if (r100 == null) goto L164;
        Long r142 = Long.valueOf(r100.getPromotionSource());
    L165:
        this.promotionSource = com.bytedance.android.shopping.extensions.k.h(r142);
        if (r100 == null) goto L168;
        String r143 = r100.getShopId();
    L169:
        this.shopId = r143;
        if (r100 == null) goto L172;
        Integer r144 = Integer.valueOf(r100.getApplyCoupon());
    L173:
        this.applyCoupon = com.bytedance.android.shopping.extensions.k.f(r144);
        if (r100 == null) goto L176;
        String r145 = r100.getBaseVerifiedCategory();
    L177:
        this.baseVerifiedCategory = r145;
        if (r100 == null) goto L180;
        String r146 = r100.getCardStatus();
    L181:
        this.cardStatus = r146;
        if (r100 == null) goto L184;
        String r147 = r100.getHotSaleType();
    L185:
        this.hotSaleType = r147;
        if (r100 == null) goto L188;
        String r148 = r100.getHotSaleSkuId();
    L189:
        this.hotSaleSkuId = r148;
        if (r100 == null) goto L192;
        String r149 = r100.getLiveRoomId();
    L193:
        this.liveRoomId = r149;
        if (r100 == null) goto L196;
        String r150 = r100.getItemId();
    L197:
        this.itemId = r150;
        if (r100 == null) goto L200;
        String r151 = r100.getAuthorId();
    L201:
        this.authorId = r151;
        if (r100 == null) goto L204;
        String r152 = r100.getSecAuthorId();
    L205:
        this.secAuthorId = r152;
        if (r100 == null) goto L208;
        Integer r153 = Integer.valueOf(r100.getFollowStatus());
    L209:
        this.followStatus = com.bytedance.android.shopping.extensions.k.f(r153);
        if (r100 == null) goto L212;
        String r154 = r100.getWhichAccount();
    L213:
        this.whichAccount = r154;
        if (r100 == null) goto L216;
        String r155 = r100.getKolUserTags();
    L217:
        this.kolUserTags = r155;
        if (r100 == null) goto L220;
        Boolean r156 = Boolean.valueOf(r100.isLuban());
    L221:
        this.isLuban = com.bytedance.android.shopping.extensions.k.i(r156);
        if (r100 == null) goto L224;
        ECAdLogExtra r157 = r100.getAdLogExtra();
    L225:
        this.adLogExtra = r157;
        if (r100 == null) goto L228;
        ECBoltParam r158 = r100.getBoltParam();
    L229:
        this.boltParam = r158;
        if (r100 == null) goto L232;
        String r159 = r100.getPageId();
    L233:
        this.pageId = r159;
        if (r100 == null) goto L236;
        String r160 = r100.getTrackExtra();
    L237:
        this.trackExtra = r160;
        if (r100 == null) goto L240;
        String r161 = r100.getLabelNameLive();
    L241:
        this.labelNameLive = r161;
        if (r100 == null) goto L244;
        String r162 = r100.getLabelName();
    L245:
        this.labelName = r162;
        if (r100 == null) goto L248;
        String r163 = r100.getChannelId();
    L249:
        this.channelId = r163;
        if (r100 == null) goto L252;
        Integer r164 = r100.getChannelType();
    L253:
        this.channelType = r164;
        if (r100 == null) goto L256;
        r101 = r100.getCpsTrack();
    L256:
        this.cpsTrack = r101;
        return this;
    L252:
        r164 = null;
        goto L253
    L248:
        r163 = null;
        goto L249
    L244:
        r162 = null;
        goto L245
    L240:
        r161 = null;
        goto L241
    L236:
        r160 = null;
        goto L237
    L232:
        r159 = null;
        goto L233
    L228:
        r158 = null;
        goto L229
    L224:
        r157 = null;
        goto L225
    L220:
        r156 = null;
        goto L221
    L216:
        r155 = null;
        goto L217
    L212:
        r154 = null;
        goto L213
    L208:
        r153 = null;
        goto L209
    L204:
        r152 = null;
        goto L205
    L200:
        r151 = null;
        goto L201
    L196:
        r150 = null;
        goto L197
    L192:
        r149 = null;
        goto L193
    L188:
        r148 = null;
        goto L189
    L184:
        r147 = null;
        goto L185
    L180:
        r146 = null;
        goto L181
    L176:
        r145 = null;
        goto L177
    L172:
        r144 = null;
        goto L173
    L168:
        r143 = null;
        goto L169
    L164:
        r142 = null;
        goto L165
    L160:
        r141 = null;
        goto L161
    L156:
        r140 = null;
        goto L157
    L152:
        r139 = null;
        goto L153
    L148:
        r138 = null;
        goto L149
    L144:
        r137 = null;
        goto L145
    L140:
        r136 = null;
        goto L141
    L136:
        r135 = null;
        goto L137
    L132:
        r134 = null;
        goto L133
    L128:
        r133 = null;
        goto L129
    L124:
        r132 = null;
        goto L125
    L120:
        r131 = null;
        goto L121
    L116:
        r130 = null;
        goto L117
    L112:
        r129 = null;
        goto L113
    L108:
        r128 = null;
        goto L109
    L104:
        r127 = null;
        goto L105
    L100:
        r126 = null;
        goto L101
    L96:
        r125 = null;
        goto L97
    L92:
        r124 = null;
        goto L93
    L88:
        r123 = null;
        goto L89
    L84:
        r122 = null;
        goto L85
    L80:
        r121 = null;
        goto L81
    L76:
        r120 = null;
        goto L77
    L72:
        r119 = null;
        goto L73
    L68:
        r118 = null;
        goto L69
    L64:
        r117 = null;
        goto L65
    L55:
        r115 = null;
        goto L56
    L51:
        r113 = null;
        goto L52
    L47:
        r112 = null;
        goto L48
    L43:
        r111 = null;
        goto L44
    L39:
        r110 = null;
        goto L40
    L35:
        r109 = null;
        goto L36
    L31:
        r108 = null;
        goto L32
    L27:
        r107 = null;
        goto L28
    L23:
        r106 = null;
        goto L24
    L17:
        r105 = null;
        goto L18
    L13:
        r104 = null;
        goto L14
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final void setAdLogExtra(ECAdLogExtra r100) {
        this.adLogExtra = r100;
    }

    public final void setAddCartMeta(AddCartMeta r100) {
        this.addCartMeta = r100;
    }

    public final void setApplyCoupon(int r100) {
        this.applyCoupon = r100;
    }

    public final void setApplyCouponIds(String r100) {
        this.applyCouponIds = r100;
    }

    public final void setAuthenticInsure(String r100) {
        this.isAuthenticInsure = r100;
    }

    public final void setAuthorId(String r100) {
        this.authorId = r100;
    }

    public final void setAvlDiscount(String r100) {
        this.avlDiscount = r100;
    }

    public final void setBaseVerifiedCategory(String r100) {
        this.baseVerifiedCategory = r100;
    }

    public final void setBoltParam(ECBoltParam r100) {
        this.boltParam = r100;
    }

    public final void setBrandVerified(String r100) {
        this.brandVerified = r100;
    }

    public final void setCampaignType(String r100) {
        this.campaignType = r100;
    }

    public final void setCardStatus(String r100) {
        this.cardStatus = r100;
    }

    public final void setChannelId(String r100) {
        this.channelId = r100;
    }

    public final void setChannelType(Integer r100) {
        this.channelType = r100;
    }

    public final void setCouponId(String r100) {
        this.couponId = r100;
    }

    public final void setCpsTrack(String r100) {
        this.cpsTrack = r100;
    }

    public final void setCrossBorderProduct(boolean r100) {
        this.isCrossBorderProduct = r100;
    }

    public final void setDefaultSpecIds(List<String> r100) {
        this.defaultSpecIds = r100;
    }

    public final void setDeliveryDelayDes(String r100) {
        this.deliveryDelayDes = r100;
    }

    public final void setDepositPreSaleActivity(PromotionDepositPresaleActivity r100) {
        this.depositPreSaleActivity = r100;
    }

    public final void setEComEntranceFrom(String r100) {
        this.eComEntranceFrom = r100;
    }

    public final void setEnterFrom(String r100) {
        this.enterFrom = r100;
    }

    public final void setEnterMethod(String r100) {
        this.enterMethod = r100;
    }

    public final void setEntranceInfo(String r100) {
        this.entranceInfo = r100;
    }

    public final void setFollowStatus(int r100) {
        this.followStatus = r100;
    }

    public final void setFromLive(boolean r100) {
        this.fromLive = r100;
    }

    public final void setFromVideo(boolean r100) {
        this.fromVideo = r100;
    }

    public final void setGroupId(String r100) {
        this.groupId = r100;
    }

    public final void setHasReplay(String r100) {
        this.hasReplay = r100;
    }

    public final void setHotSaleSkuId(String r100) {
        this.hotSaleSkuId = r100;
    }

    public final void setHotSaleType(String r100) {
        this.hotSaleType = r100;
    }

    public final void setItemId(String r100) {
        this.itemId = r100;
    }

    public final void setKolUserTags(String r100) {
        this.kolUserTags = r100;
    }

    public final void setLabelName(String r100) {
        this.labelName = r100;
    }

    public final void setLabelNameLive(String r100) {
        this.labelNameLive = r100;
    }

    public final void setLiveRoomId(String r100) {
        this.liveRoomId = r100;
    }

    public final void setLogData(String r100) {
        this.logData = r100;
    }

    public final void setLuban(boolean r100) {
        this.isLuban = r100;
    }

    public final void setMarketingChannel(String r100) {
        this.marketingChannel = r100;
    }

    public final void setMetaParam(String r100) {
        this.metaParam = r100;
    }

    public final void setOriginId(String r100) {
        this.originId = r100;
    }

    public final void setOriginType(String r100) {
        this.originType = r100;
    }

    public final void setPageId(String r100) {
        this.pageId = r100;
    }

    public final void setPassThroughEventData(String r100) {
        this.passThroughEventData = r100;
    }

    public final void setPreSellDelayDes(String r100) {
        this.preSellDelayDes = r100;
    }

    public final void setPreSellType(int r100) {
        this.preSellType = r100;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public final void setPromotionId(String r100) {
        this.promotionId = r100;
    }

    public final void setPromotionSource(long r100) {
        this.promotionSource = r100;
    }

    public final void setRebateId(String r100) {
        this.rebateId = r100;
    }

    public final void setRequestAdditions(String r100) {
        this.requestAdditions = r100;
    }

    public final void setSecAuthorId(String r100) {
        this.secAuthorId = r100;
    }

    public final void setShopId(String r100) {
        this.shopId = r100;
    }

    public final void setShowInstallmentFlag(boolean r100) {
        this.showInstallmentFlag = r100;
    }

    public final void setSourcePage(String r100) {
        this.sourcePage = r100;
    }

    public final void setThirdParty(boolean r100) {
        this.thirdParty = r100;
    }

    public final void setThreeDLogData(String r100) {
        this.threeDLogData = r100;
    }

    public final void setTrackExtra(String r100) {
        this.trackExtra = r100;
    }

    public final void setTransmissibleJson(String r100) {
        this.transmissibleJson = r100;
    }

    public final void setV3EventsAdditions(String r100) {
        this.v3EventsAdditions = r100;
    }

    public final void setVirtual(boolean r100) {
        this.isVirtual = r100;
    }

    public final void setWhichAccount(String r100) {
        this.whichAccount = r100;
    }

    public final void setWithSku(String r100) {
        this.withSku = r100;
    }

    public final void setWithVideo(String r100) {
        this.withVideo = r100;
    }

    public final String chooseTheRightOrderUrl(boolean r100, boolean r101) {
        if (r101 == true) goto L8;
        if (r100 == false) goto L7;
        return this.groupBuyOrderUrl;
    L7:
        return this.orderUrl;
    L8:
        return this.customBuyOrderUrl;
    }

    public final IAction getSchemaSkuAction(boolean r100, boolean r101, boolean r102) {
        if (r100 == true) goto L10;
        if (r101 == true) goto L11;
        if (r102 == false) goto L9;
        return com.bytedance.android.ecom.arch.slice.action.n.a(this.skuCustomBuyAction);
    L9:
        return com.bytedance.android.ecom.arch.slice.action.n.a(this.skuBuyAction);
    L11:
        return com.bytedance.android.ecom.arch.slice.action.n.a(this.skuGroupBuyAction);
    L10:
        return com.bytedance.android.ecom.arch.slice.action.n.a(this.skuAddCartAction);
    }

    public SkuMeta(String r100, String r101, String r102, String r103, String r104, String r105, String r110, boolean r111, boolean r112, String r113, String r114, String r115, String r116, String r117, String r118, boolean r119, String r210, String r211, String r212, String r213, String r214, int r215, String r216, String r217, String r218, PromotionDepositPresaleActivity r219, String r310, String r311, String r312, String r313, String r314, boolean r315, String r316, boolean r317, boolean r318, String r319, String r410, long r411, String r412, String r413, int r414, String r415, String r416, String r417, String r418, AddCartMeta r510, String r511, String r512, String r513, String r514, int r515, String r516, String r517, boolean r518, ECAdLogExtra r519, ECBoltParam r610, String r611, String r612, String r613, String r614, String r615, ECUrlModel r616, boolean r617, String r618, LinkedTreeMap<String, Object> r619, String r710, String r711, String r712, String r713, String r714, String r715, boolean r716, long r717, long r718, long r810, boolean r811, String r812, String r813, Integer r814, String r815, List<String> r816, String r817, String r910, Map<?, ?> r911, Map<?, ?> r912, Map<?, ?> r913, Map<?, ?> r914) {
        this.transmissibleJson = r100;
        this.sourcePage = r101;
        this.enterMethod = r102;
        this.entranceInfo = r103;
        this.metaParam = r104;
        this.v3EventsAdditions = r105;
        this.eComEntranceFrom = r110;
        this.fromLive = r111;
        this.fromVideo = r112;
        this.passThroughEventData = r113;
        this.enterFrom = r114;
        this.groupId = r115;
        this.originType = r116;
        this.originId = r117;
        this.brandVerified = r118;
        this.isCrossBorderProduct = r119;
        this.goodsType = r210;
        this.isAuthenticInsure = r211;
        this.hasReplay = r212;
        this.withVideo = r213;
        this.threeDLogData = r214;
        this.preSellType = r215;
        this.preSellDelayDes = r216;
        this.deliveryDelayDes = r217;
        this.logData = r218;
        this.depositPreSaleActivity = r219;
        this.rebateId = r310;
        this.avlDiscount = r311;
        this.couponId = r312;
        this.withSku = r313;
        this.campaignType = r314;
        this.showInstallmentFlag = r315;
        this.requestAdditions = r316;
        this.thirdParty = r317;
        this.isVirtual = r318;
        this.productId = r319;
        this.promotionId = r410;
        this.promotionSource = r411;
        this.shopId = r412;
        this.applyCouponIds = r413;
        this.applyCoupon = r414;
        this.baseVerifiedCategory = r415;
        this.cardStatus = r416;
        this.hotSaleType = r417;
        this.hotSaleSkuId = r418;
        this.addCartMeta = r510;
        this.liveRoomId = r511;
        this.itemId = r512;
        this.authorId = r513;
        this.secAuthorId = r514;
        this.followStatus = r515;
        this.whichAccount = r516;
        this.kolUserTags = r517;
        this.isLuban = r518;
        this.adLogExtra = r519;
        this.boltParam = r610;
        this.pageId = r611;
        this.labelNameLive = r612;
        this.labelName = r613;
        this.trackExtra = r614;
        this.marketingChannel = r615;
        this.firstImage = r616;
        this.setCartGray = r617;
        this.productTypeVerified = r618;
        this.trackMeta = r619;
        this.recommendInfo = r710;
        this.receiveAddressId = r711;
        this.cashRebate = r712;
        this.orderUrl = r713;
        this.groupBuyOrderUrl = r714;
        this.customBuyOrderUrl = r715;
        this.hasSecActivity = r716;
        this.secActivityBeginTime = r717;
        this.secActivityEndTime = r718;
        this.secActivityServerTime = r810;
        this.scrollToDouInstallment = r811;
        this.selectedCarId = r812;
        this.channelId = r813;
        this.channelType = r814;
        this.cpsTrack = r815;
        this.defaultSpecIds = r816;
        this.bizCampaignType = r817;
        this.nGroupBuyToken = r910;
        this.skuAddCartAction = r911;
        this.skuGroupBuyAction = r912;
        this.skuCustomBuyAction = r913;
        this.skuBuyAction = r914;
    }

    public /* synthetic */ SkuMeta(String r910, String r911, String r912, String r913, String r914, String r915, String r916, boolean r917, boolean r918, String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, String r107, String r108, String r109, String r110, String r111, int r112, String r113, String r114, String r115, PromotionDepositPresaleActivity r116, String r117, String r118, String r119, String r120, String r121, boolean r122, String r123, boolean r124, boolean r125, String r126, String r127, long r128, String r130, String r131, int r132, String r133, String r134, String r135, String r136, AddCartMeta r137, String r138, String r139, String r140, String r141, int r142, String r143, String r144, boolean r145, ECAdLogExtra r146, ECBoltParam r147, String r148, String r149, String r150, String r151, String r152, ECUrlModel r153, boolean r154, String r155, LinkedTreeMap r156, String r157, String r158, String r159, String r160, String r161, String r162, boolean r163, long r164, long r166, long r168, boolean r170, String r171, String r172, Integer r173, String r174, List r175, String r176, String r177, Map r178, Map r179, Map r180, Map r181, int r182, int r183, int r184, DefaultConstructorMarker r185) {
        if ((r182 & 1) == 0) goto L5;
        String r129 = null;
    L7:
        if ((r182 & 2) == 0) goto L9;
        String r165 = null;
    L11:
        if ((r182 & 4) == 0) goto L13;
        String r167 = null;
    L15:
        if ((r182 & 8) == 0) goto L17;
        String r169 = null;
    L19:
        if ((r182 & 16) == 0) goto L21;
        String r186 = null;
    L23:
        if ((r182 & 32) == 0) goto L25;
        String r187 = null;
    L27:
        if ((r182 & 64) == 0) goto L29;
        String r188 = null;
    L31:
        if ((r182 & 128) == 0) goto L33;
        boolean r189 = false;
    L35:
        if ((r182 & 256) == 0) goto L37;
        boolean r190 = false;
    L39:
        if ((r182 & 512) == 0) goto L41;
        String r191 = null;
    L43:
        if ((r182 & 1024) == 0) goto L45;
        String r192 = null;
    L47:
        if ((r182 & 2048) == 0) goto L49;
        String r193 = null;
    L51:
        if ((r182 & 4096) == 0) goto L53;
        String r194 = null;
    L54:
        String r195 = r194;
        if ((r182 & 8192) == 0) goto L57;
        String r196 = null;
    L58:
        String r197 = r196;
        if ((r182 & 16384) == 0) goto L61;
        String r198 = null;
    L63:
        if ((r182 & 32768) == 0) goto L65;
        boolean r199 = false;
    L67:
        if ((r182 & 65536) == 0) goto L69;
        String r210 = null;
    L71:
        if ((r182 & 131072) == 0) goto L73;
        String r211 = null;
    L75:
        if ((r182 & 262144) == 0) goto L77;
        String r212 = null;
    L79:
        if ((r182 & 524288) == 0) goto L81;
        String r213 = null;
    L83:
        if ((r182 & 1048576) == 0) goto L85;
        String r214 = null;
    L87:
        if ((r182 & 2097152) == 0) goto L89;
        int r215 = 0;
    L91:
        if ((r182 & 4194304) == 0) goto L93;
        String r216 = null;
    L95:
        if ((r182 & 8388608) == 0) goto L97;
        String r310 = null;
    L99:
        if ((r182 & 16777216) == 0) goto L101;
        String r311 = null;
    L103:
        if ((r182 & 33554432) == 0) goto L105;
        PromotionDepositPresaleActivity r312 = null;
    L107:
        if ((r182 & 67108864) == 0) goto L109;
        String r313 = null;
    L111:
        if ((r182 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        String r314 = null;
    L115:
        if ((r182 & 268435456) == 0) goto L117;
        String r315 = null;
    L119:
        if ((r182 & 536870912) == 0) goto L121;
        String r316 = null;
    L123:
        if ((r182 & 1073741824) == 0) goto L125;
        String r317 = null;
    L127:
        if ((r182 & Integer.MIN_VALUE) == 0) goto L129;
        boolean r200 = false;
    L131:
        if ((r183 & 1) == 0) goto L133;
        String r318 = null;
    L135:
        if ((r183 & 2) == 0) goto L137;
        boolean r319 = false;
    L139:
        if ((r183 & 4) == 0) goto L141;
        boolean r410 = false;
    L143:
        if ((r183 & 8) == 0) goto L145;
        String r411 = null;
    L147:
        if ((r183 & 16) == 0) goto L149;
        String r412 = null;
    L150:
        long r413 = 0;
        if ((r183 & 32) == 0) goto L153;
        long r414 = 0;
    L155:
        if ((r183 & 64) == 0) goto L157;
        String r415 = null;
    L158:
        boolean r1810 = r200;
        if ((r183 & 128) == 0) goto L161;
        String r201 = null;
    L162:
        String r416 = r201;
        if ((r183 & 256) == 0) goto L165;
        int r202 = 0;
    L166:
        int r417 = r202;
        if ((r183 & 512) == 0) goto L169;
        String r203 = null;
    L170:
        String r510 = r203;
        if ((r183 & 1024) == 0) goto L173;
        String r204 = null;
    L174:
        String r511 = r204;
        if ((r183 & 2048) == 0) goto L177;
        String r205 = null;
    L178:
        String r512 = r205;
        if ((r183 & 4096) == 0) goto L181;
        String r206 = null;
    L182:
        String r513 = r206;
        if ((r183 & 8192) == 0) goto L185;
        AddCartMeta r207 = null;
    L186:
        AddCartMeta r514 = r207;
        if ((r183 & 16384) == 0) goto L189;
        String r208 = null;
    L191:
        if ((r183 & 32768) == 0) goto L193;
        String r515 = null;
    L195:
        if ((r183 & 65536) == 0) goto L197;
        String r516 = null;
    L199:
        if ((r183 & 131072) == 0) goto L201;
        String r517 = null;
    L203:
        if ((r183 & 262144) == 0) goto L205;
        int r518 = 0;
    L207:
        if ((r183 & 524288) == 0) goto L209;
        String r519 = null;
    L211:
        if ((r183 & 1048576) == 0) goto L213;
        String r610 = null;
    L215:
        if ((r183 & 2097152) == 0) goto L217;
        boolean r611 = false;
    L219:
        if ((r183 & 4194304) == 0) goto L221;
        ECAdLogExtra r612 = null;
    L223:
        if ((r183 & 8388608) == 0) goto L225;
        ECBoltParam r613 = null;
    L227:
        if ((r183 & 16777216) == 0) goto L229;
        String r614 = null;
    L231:
        if ((r183 & 33554432) == 0) goto L233;
        String r615 = null;
    L235:
        if ((r183 & 67108864) == 0) goto L237;
        String r616 = null;
    L239:
        if ((r183 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L241;
        String r617 = null;
    L243:
        if ((r183 & 268435456) == 0) goto L245;
        String r618 = null;
    L247:
        if ((r183 & 536870912) == 0) goto L249;
        ECUrlModel r619 = null;
    L251:
        if ((r183 & 1073741824) == 0) goto L253;
        boolean r710 = false;
    L255:
        if ((r183 & Integer.MIN_VALUE) == 0) goto L257;
        String r209 = null;
    L259:
        if ((r184 & 1) == 0) goto L261;
        LinkedTreeMap r711 = null;
    L263:
        if ((r184 & 2) == 0) goto L265;
        String r712 = null;
    L267:
        if ((r184 & 4) == 0) goto L269;
        String r713 = null;
    L271:
        if ((r184 & 8) == 0) goto L273;
        String r714 = null;
    L275:
        if ((r184 & 16) == 0) goto L277;
        String r715 = null;
    L279:
        if ((r184 & 32) == 0) goto L281;
        String r716 = null;
    L283:
        if ((r184 & 64) == 0) goto L285;
        String r717 = null;
    L286:
        String r1811 = r209;
        if ((r184 & 128) == 0) goto L289;
        boolean r217 = false;
    L290:
        boolean r718 = r217;
        if ((r184 & 256) == 0) goto L293;
        long r719 = 0;
    L295:
        if ((r184 & 512) == 0) goto L297;
        long r810 = 0;
    L299:
        if ((r184 & 1024) != 0) goto L303;
        r413 = r168;
    L303:
        if ((r184 & 2048) == 0) goto L305;
        boolean r218 = false;
    L306:
        boolean r811 = r218;
        if ((r184 & 4096) == 0) goto L309;
        String r219 = null;
    L310:
        String r812 = r219;
        if ((r184 & 8192) == 0) goto L313;
        String r220 = null;
    L314:
        String r813 = r220;
        if ((r184 & 16384) == 0) goto L317;
        Integer r221 = 0;
    L319:
        if ((r184 & 32768) == 0) goto L321;
        String r1100 = null;
    L323:
        if ((r184 & 65536) == 0) goto L325;
        List r222 = null;
    L327:
        if ((r184 & 131072) == 0) goto L329;
        String r223 = null;
    L331:
        if ((r184 & 262144) == 0) goto L333;
        String r224 = null;
    L335:
        if ((r184 & 524288) == 0) goto L337;
        Map r814 = null;
    L339:
        if ((r184 & 1048576) == 0) goto L341;
        Map r815 = null;
    L343:
        if ((r184 & 2097152) == 0) goto L345;
        Map r816 = null;
    L347:
        if ((r184 & 4194304) == 0) goto L349;
        Map r225 = null;
    L350:
        this(r129, r165, r167, r169, r186, r187, r188, r189, r190, r191, r192, r193, r195, r197, r198, r199, r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r1810, r318, r319, r410, r411, r412, r414, r415, r416, r417, r510, r511, r512, r513, r514, r208, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r1811, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r413, r811, r812, r813, r221, r1100, r222, r223, r224, r814, r815, r816, r225);
        return;
    L349:
        r225 = r181;
        goto L350
    L345:
        r816 = r180;
        goto L347
    L341:
        r815 = r179;
        goto L343
    L337:
        r814 = r178;
        goto L339
    L333:
        r224 = r177;
        goto L335
    L329:
        r223 = r176;
        goto L331
    L325:
        r222 = r175;
        goto L327
    L321:
        r1100 = r174;
        goto L323
    L317:
        r221 = r173;
        goto L319
    L313:
        r220 = r172;
        goto L314
    L309:
        r219 = r171;
        goto L310
    L305:
        r218 = r170;
        goto L306
    L297:
        r810 = r166;
        goto L299
    L293:
        r719 = r164;
        goto L295
    L289:
        r217 = r163;
        goto L290
    L285:
        r717 = r162;
        goto L286
    L281:
        r716 = r161;
        goto L283
    L277:
        r715 = r160;
        goto L279
    L273:
        r714 = r159;
        goto L275
    L269:
        r713 = r158;
        goto L271
    L265:
        r712 = r157;
        goto L267
    L261:
        r711 = r156;
        goto L263
    L257:
        r209 = r155;
        goto L259
    L253:
        r710 = r154;
        goto L255
    L249:
        r619 = r153;
        goto L251
    L245:
        r618 = r152;
        goto L247
    L241:
        r617 = r151;
        goto L243
    L237:
        r616 = r150;
        goto L239
    L233:
        r615 = r149;
        goto L235
    L229:
        r614 = r148;
        goto L231
    L225:
        r613 = r147;
        goto L227
    L221:
        r612 = r146;
        goto L223
    L217:
        r611 = r145;
        goto L219
    L213:
        r610 = r144;
        goto L215
    L209:
        r519 = r143;
        goto L211
    L205:
        r518 = r142;
        goto L207
    L201:
        r517 = r141;
        goto L203
    L197:
        r516 = r140;
        goto L199
    L193:
        r515 = r139;
        goto L195
    L189:
        r208 = r138;
        goto L191
    L185:
        r207 = r137;
        goto L186
    L181:
        r206 = r136;
        goto L182
    L177:
        r205 = r135;
        goto L178
    L173:
        r204 = r134;
        goto L174
    L169:
        r203 = r133;
        goto L170
    L165:
        r202 = r132;
        goto L166
    L161:
        r201 = r131;
        goto L162
    L157:
        r415 = r130;
        goto L158
    L153:
        r414 = r128;
        goto L155
    L149:
        r412 = r127;
        goto L150
    L145:
        r411 = r126;
        goto L147
    L141:
        r410 = r125;
        goto L143
    L137:
        r319 = r124;
        goto L139
    L133:
        r318 = r123;
        goto L135
    L129:
        r200 = r122;
        goto L131
    L125:
        r317 = r121;
        goto L127
    L121:
        r316 = r120;
        goto L123
    L117:
        r315 = r119;
        goto L119
    L113:
        r314 = r118;
        goto L115
    L109:
        r313 = r117;
        goto L111
    L105:
        r312 = r116;
        goto L107
    L101:
        r311 = r115;
        goto L103
    L97:
        r310 = r114;
        goto L99
    L93:
        r216 = r113;
        goto L95
    L89:
        r215 = r112;
        goto L91
    L85:
        r214 = r111;
        goto L87
    L81:
        r213 = r110;
        goto L83
    L77:
        r212 = r109;
        goto L79
    L73:
        r211 = r108;
        goto L75
    L69:
        r210 = r107;
        goto L71
    L65:
        r199 = r106;
        goto L67
    L61:
        r198 = r105;
        goto L63
    L57:
        r196 = r104;
        goto L58
    L53:
        r194 = r103;
        goto L54
    L49:
        r193 = r102;
        goto L51
    L45:
        r192 = r101;
        goto L47
    L41:
        r191 = r100;
        goto L43
    L37:
        r190 = r918;
        goto L39
    L33:
        r189 = r917;
        goto L35
    L29:
        r188 = r916;
        goto L31
    L25:
        r187 = r915;
        goto L27
    L21:
        r186 = r914;
        goto L23
    L17:
        r169 = r913;
        goto L19
    L13:
        r167 = r912;
        goto L15
    L9:
        r165 = r911;
        goto L11
    L5:
        r129 = r910;
        goto L7
    }
}
