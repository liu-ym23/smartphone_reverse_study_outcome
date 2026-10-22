package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import N5.CardEnvelope;
import N5.CardLinks;
import Z8.C1173v;
import Z8.C1174w;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.foundation.R$color;
import com.stepos.ailauncher.foundation.R$drawable;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.AbstractC3297l;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardModel;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u0082\u00012\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u00ad\u0001\u0010'\u001a\u00020&2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00122\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b'\u0010(J+\u0010*\u001a\u00020&2\u0006\u0010)\u001a\u00020&2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b*\u0010+J7\u0010-\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b-\u0010.J-\u00102\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u000e2\b\u0010/\u001a\u0004\u0018\u00010\u00122\b\u00101\u001a\u0004\u0018\u000100H\u0002¢\u0006\u0004\b2\u00103J\u001b\u00106\u001a\u0004\u0018\u00010\u00122\b\u00105\u001a\u0004\u0018\u000104H\u0002¢\u0006\u0004\b6\u00107J#\u00108\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b8\u00109J9\u0010>\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010;\u001a\u0004\u0018\u00010:2\u0012\u0010=\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120<\"\u00020\u0012H\u0002¢\u0006\u0004\b>\u0010?J\u001b\u0010A\u001a\u0004\u0018\u00010\u00122\b\u0010@\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\bA\u0010BJ\u001b\u0010D\u001a\u0004\u0018\u00010\u00122\b\u0010C\u001a\u0004\u0018\u000100H\u0002¢\u0006\u0004\bD\u0010EJ\u0017\u0010G\u001a\u00020\u00122\u0006\u0010F\u001a\u000200H\u0002¢\u0006\u0004\bG\u0010HJ3\u0010K\u001a\u00020&2\u0006\u0010)\u001a\u00020&2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010J\u001a\u0004\u0018\u00010I2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\bK\u0010LJ)\u0010M\u001a\u00020&2\u0006\u0010)\u001a\u00020&2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\bM\u0010NJ\u0017\u0010P\u001a\u00020O2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\bP\u0010QJ\u0011\u0010R\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bR\u0010SJ-\u0010V\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00120U2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002¢\u0006\u0004\bV\u0010WJ!\u0010Z\u001a\u00020\u00122\b\u0010X\u001a\u0004\u0018\u00010\u00122\u0006\u0010Y\u001a\u00020\u0012H\u0002¢\u0006\u0004\bZ\u0010[JG\u0010^\u001a\u0004\u0018\u00010]2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\\\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b^\u0010_J5\u0010`\u001a\u0004\u0018\u00010]2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\\\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b`\u0010aJ#\u0010b\u001a\u0004\u0018\u00010]2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\\\u001a\u00020\u0012H\u0002¢\u0006\u0004\bb\u0010cJ#\u0010d\u001a\u0004\u0018\u00010]2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\\\u001a\u00020\u0012H\u0002¢\u0006\u0004\bd\u0010cJ¿\u0001\u0010s\u001a\u0004\u0018\u00010]2\b\u0010J\u001a\u0004\u0018\u00010I2\u0006\u0010\\\u001a\u00020\u00122\b\b\u0001\u0010e\u001a\u00020\u000e2\b\b\u0003\u0010f\u001a\u00020\u000e2\b\b\u0002\u0010g\u001a\u00020O2\b\b\u0002\u0010h\u001a\u00020O2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010j\u001a\u00020O2\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010o\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010p\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010q\u001a\u00020O2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\bs\u0010tJ#\u0010w\u001a\u0004\u0018\u00010v2\u0006\u0010u\u001a\u00020\u00122\b\u0010F\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\bw\u0010xJ%\u0010|\u001a\b\u0012\u0004\u0012\u00020{0\u00182\u000e\u0010z\u001a\n\u0012\u0004\u0012\u00020y\u0018\u00010\u0018H\u0002¢\u0006\u0004\b|\u0010}J+\u0010~\u001a\b\u0012\u0004\u0012\u00020{0\u00182\f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b~\u0010\u007fJ\u001c\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001¨\u0006\u0083\u0001"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardProvider;", "LN5/v;", "<init>", "()V", "LN5/i;", "envelope", "LN5/n;", Const.INTENT_KEY_PKGNAME, "(LN5/i;)LN5/n;", "Landroid/content/Context;", "context", "LN5/d;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)LN5/d;", "", "statusCode", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/Integer;)Ljava/lang/Integer;", "", "taskId", "status", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/w;", Const.INTENT_KEY_UMID, "errorMessage", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/J;", "estimateItems", "LN5/m;", "links", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;", "vendor", "bizChannel", "sessionId", "messageId", "toolCallId", "envelopePlatformOrderId", "requestTraceId", "envelopeClientRenderSource", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;ILcom/stepos/ailauncher/foundation/appui/card/provider/didi/w;Ljava/lang/String;Ljava/util/List;LN5/m;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;", "base", "k", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/w;Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;", "summaryTitle", "s", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/w;ILjava/lang/String;LN5/m;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/w;", "itemEta", "", "mapEta", "t", "(ILjava/lang/String;Ljava/lang/Double;)Ljava/lang/String;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/I;", "driver", "B", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/I;)Ljava/lang/String;", "u", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/w;Ljava/lang/String;)Ljava/lang/String;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/P;", "item", "", "labels", "p", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/w;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/P;[Ljava/lang/String;)Ljava/lang/String;", "text", "w", "(Ljava/lang/String;)Ljava/lang/String;", "distanceKm", "m", "(Ljava/lang/Double;)Ljava/lang/String;", UxipConstants.f30680s, "l", "(D)Ljava/lang/String;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/g;", "action", "f", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/w;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/g;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/w;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;", "", "C", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;)Z", "e", "()Landroid/content/Context;", DidiCardProvider.KEY_ITEMS, "Lkotlin/Pair;", "o", "(Ljava/util/List;)Lkotlin/Pair;", "appId", "pkg", "r", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "fallbackLabel", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$a;", "v", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/w;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;Ljava/lang/String;ILN5/m;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$a;", "z", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/w;Ljava/lang/String;LN5/m;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$a;", "y", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/w;Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$a;", "x", "background", "textColor", "localDismiss", "localDim", "launchPackage", "showLoading", "fallbackAppLink", "fallbackWebLink", "fallbackLaunchPackage", "intentPackage", "storeLink", "storeLinkPackage", "sendsChatReply", "chatReplyText", "c", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/g;Ljava/lang/String;IIZZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$a;", "label", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$d;", "q", "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$d;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/x;", "raw", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$c;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/List;)Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/util/List;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;)Ljava/util/List;", "n", "(LN5/i;)Ljava/lang/String;", "Companion", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DidiCardProvider implements N5.v {
    public static final String ACTION_DISMISS = "dismiss";
    public static final String DEFAULT_APP_NAME = "打车";
    public static final String DEFAULT_AUTH_SUBTITLE = "授权账号，用于发起订单。";
    public static final String DEFAULT_AUTH_TITLE = "请求授权";
    public static final String DEFAULT_DISCLAIMER = "预估价、优惠与接驾时间可能变化，实际费用以订单为准";
    public static final String DEFAULT_FINISHED_TITLE = "订单已完成";
    public static final String DEFAULT_MATCHING_TITLE = "正在匹配司机";
    public static final String DEFAULT_PICKUP_TITLE = "司机正在接驾中";
    public static final String DEFAULT_STORE_NAME = "应用商店";
    public static final String KEY_ITEMS = "items";
    public static final String KEY_ORDER = "order";
    public static final String KEY_TRACE_ID = "traceId";
    public static final String LABEL_ACCOUNT = "手机尾号";
    public static final String LABEL_ACTUAL_FEE = "实付金额";
    public static final String LABEL_AUTH = "去授权";
    public static final String LABEL_AUTHORIZED_SUBTITLE = "授权滴滴账号，用于发起订单。";
    public static final String LABEL_AUTHORIZED_TITLE = "滴滴已授权";
    public static final String LABEL_CALL_CAR = "立即打车";
    public static final String LABEL_CAOCAO_AUTHORIZED_SUBTITLE = "授权曹操账号，用于发起订单。";
    public static final String LABEL_CAOCAO_AUTHORIZED_TITLE = "曹操已授权";
    public static final String LABEL_CAR_TYPE = "所选车型";
    public static final String LABEL_CONTACT_DRIVER = "联系司机";
    public static final String LABEL_CURRENT_CAR_TYPE = "当前呼叫车型";
    public static final String LABEL_DISMISS = "暂不";
    public static final String LABEL_ESTIMATED_FEE = "预估金额";
    public static final String LABEL_ORDER_NO = "订单号";
    public static final String LABEL_PICKUP_POINT = "上车点";
    public static final String LABEL_VIEW_ORDER = "查看订单";
    public static final String LABEL_VIEW_RECEIPT = "查看行程";
    public static final String LABEL_VIEW_TRIP = "查看行程";
    public static final String MARKET_SOURCE = "amoo";
    public static final String PKG_APPSTORE = "com.stepos.appstore";
    public static final String TASK_ID_ORDER_PREFIX = "taxi_order_";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<Integer> KNOWN_STATUSES = Z8.Y.j(90, 91, 1, 2, 3, 4, 5, 6, 7, 27, 8, 9, 10, 0);
    private static final Regex PHONE_SUFFIX_REGEX = new Regex("(?<!\\d)(\\d{3,11})(?!\\d)");

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000e\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000f\u0010\bJ+\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\fJ\u001f\u0010\u0017\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\fJ\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\bJ\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\bJ\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0014\u0010!\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010\u001fR\u0014\u0010#\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\u001fR\u0014\u0010$\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010\u001fR\u0014\u0010%\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010\u001fR\u0014\u0010&\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010\u001fR\u0014\u0010'\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010\u001fR\u0014\u0010(\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b(\u0010\u001fR\u0014\u0010)\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b)\u0010\u001fR\u0014\u0010*\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b*\u0010\u001fR\u0014\u0010+\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b+\u0010\u001fR\u0014\u0010,\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b,\u0010\u001fR\u0014\u0010-\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b-\u0010\u001fR\u0014\u0010.\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b.\u0010\u001fR\u0014\u0010/\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b/\u0010\u001fR\u0014\u00100\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b0\u0010\u001fR\u0014\u00101\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b1\u0010\u001fR\u0014\u00102\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b2\u0010\u001fR\u0014\u00103\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b3\u0010\u001fR\u0014\u00104\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b4\u0010\u001fR\u0014\u00105\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b5\u0010\u001fR\u0014\u00106\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b6\u0010\u001fR\u0014\u00107\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b7\u0010\u001fR\u0014\u00108\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b8\u0010\u001fR\u0014\u00109\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b9\u0010\u001fR\u0014\u0010:\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b:\u0010\u001fR\u0014\u0010;\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b;\u0010\u001fR\u0014\u0010<\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b<\u0010\u001fR\u0014\u0010=\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b=\u0010\u001fR\u0014\u0010>\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b>\u0010\u001fR\u0014\u0010?\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b?\u0010\u001fR\u0014\u0010A\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010B¨\u0006C"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardProvider$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;)Z", "current", "cancelled", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;)Z", "incoming", "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, AbstractC3297l.KEY_AUTH, "", "title", "subtitle", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;", "e", Const.INTENT_KEY_BACKGROUND_COMMAND, "c", Const.INTENT_KEY_UMID, "", "status", "f", "(I)Z", "KEY_ORDER", "Ljava/lang/String;", "KEY_ITEMS", "KEY_TRACE_ID", "ACTION_DISMISS", "PKG_APPSTORE", "MARKET_SOURCE", "DEFAULT_STORE_NAME", "DEFAULT_APP_NAME", "DEFAULT_AUTH_TITLE", "DEFAULT_AUTH_SUBTITLE", "DEFAULT_MATCHING_TITLE", "DEFAULT_PICKUP_TITLE", "DEFAULT_FINISHED_TITLE", "DEFAULT_DISCLAIMER", "LABEL_AUTHORIZED_TITLE", "LABEL_AUTHORIZED_SUBTITLE", "LABEL_CAOCAO_AUTHORIZED_TITLE", "LABEL_CAOCAO_AUTHORIZED_SUBTITLE", "LABEL_DISMISS", "LABEL_AUTH", "LABEL_CALL_CAR", "LABEL_VIEW_ORDER", "LABEL_CONTACT_DRIVER", "LABEL_VIEW_TRIP", "LABEL_VIEW_RECEIPT", "LABEL_CAR_TYPE", "LABEL_ACCOUNT", "LABEL_PICKUP_POINT", "LABEL_ESTIMATED_FEE", "LABEL_ACTUAL_FEE", "LABEL_CURRENT_CAR_TYPE", "LABEL_ORDER_NO", "TASK_ID_ORDER_PREFIX", "Lkotlin/text/Regex;", "PHONE_SUFFIX_REGEX", "Lkotlin/text/Regex;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ DidiCardModel b(Companion companion, DidiCardModel didiCardModel, String str, String str2, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                str = DidiCardProvider.LABEL_AUTHORIZED_TITLE;
            }
            if ((i10 & 4) != 0) {
                str2 = DidiCardProvider.LABEL_AUTHORIZED_SUBTITLE;
            }
            return companion.a(didiCardModel, str, str2);
        }

        public final DidiCardModel a(DidiCardModel auth, String title, String subtitle) {
            kotlin.jvm.internal.p.i(auth, "auth");
            kotlin.jvm.internal.p.i(title, "title");
            kotlin.jvm.internal.p.i(subtitle, "subtitle");
            return DidiCardModel.c(auth, null, 0, false, null, null, null, null, null, null, null, null, null, 0, 0, null, null, null, title, subtitle, null, null, null, null, "滴滴账号授权成功,可以正常发起打车订单", null, null, null, null, null, null, null, null, null, null, null, null, -8781825, 1, null);
        }

        public final boolean c(DidiCardModel model) {
            return model.getStatus() == 7 && d(model);
        }

        public final boolean d(DidiCardModel model) {
            return La.D.L(model.getBizChannel(), q0.CAOCAO, true);
        }

        public final boolean e(DidiCardModel current, DidiCardModel incoming) {
            if (!d(current)) {
                return false;
            }
            if (incoming.getBizChannel() == null || d(incoming)) {
                return f(current.getStatus());
            }
            return false;
        }

        public final boolean f(int status) {
            return status == 1 || status == 2 || status == 3 || status == 4 || status == 5 || status == 6;
        }

        public final boolean g(DidiCardModel current, DidiCardModel incoming) {
            String orderNo = current.getOrderNo();
            String orderNo2 = incoming.getOrderNo();
            if (orderNo == null || orderNo.length() == 0 || orderNo2 == null || orderNo2.length() == 0 || !kotlin.jvm.internal.p.d(orderNo, orderNo2)) {
                return current.getCardId().length() > 0 && kotlin.jvm.internal.p.d(current.getCardId(), incoming.getCardId());
            }
            return true;
        }

        public final boolean h(DidiCardModel model) {
            kotlin.jvm.internal.p.i(model, "model");
            return d(model) && f(model.getStatus());
        }

        public final boolean i(DidiCardModel current, DidiCardModel cancelled) {
            kotlin.jvm.internal.p.i(cancelled, "cancelled");
            if (current != null && c(cancelled) && e(current, cancelled)) {
                return g(current, cancelled);
            }
            return false;
        }

        public final boolean j(DidiCardModel model) {
            kotlin.jvm.internal.p.i(model, "model");
            return c(model);
        }

        public final boolean k(DidiCardModel current, DidiCardModel incoming) {
            kotlin.jvm.internal.p.i(incoming, "incoming");
            if (current != null && e(current, incoming)) {
                return g(current, incoming);
            }
            return false;
        }

        public Companion() {
        }
    }

    public static /* synthetic */ DidiCardModel.ActionItem d(DidiCardProvider didiCardProvider, DidiAction didiAction, String str, int i10, int i11, boolean z10, boolean z11, String str2, boolean z12, String str3, String str4, String str5, String str6, String str7, String str8, boolean z13, String str9, int i12, Object obj) {
        String str10;
        DidiCardProvider didiCardProvider2;
        DidiAction didiAction2;
        String str11;
        int i13;
        int i14 = (i12 & 8) != 0 ? R$color.card_text_primary : i11;
        boolean z14 = (i12 & 16) != 0 ? false : z10;
        boolean z15 = (i12 & 32) != 0 ? false : z11;
        String str12 = (i12 & 64) != 0 ? null : str2;
        boolean z16 = (i12 & 128) != 0 ? false : z12;
        String str13 = (i12 & 256) != 0 ? null : str3;
        String str14 = (i12 & 512) != 0 ? null : str4;
        String str15 = (i12 & 1024) != 0 ? null : str5;
        String str16 = (i12 & 2048) != 0 ? null : str6;
        String str17 = (i12 & 4096) != 0 ? null : str7;
        String str18 = (i12 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? null : str8;
        boolean z17 = (i12 & 16384) != 0 ? false : z13;
        if ((i12 & 32768) != 0) {
            str10 = null;
            didiCardProvider2 = didiCardProvider;
            str11 = str;
            i13 = i10;
            didiAction2 = didiAction;
        } else {
            str10 = str9;
            didiCardProvider2 = didiCardProvider;
            didiAction2 = didiAction;
            str11 = str;
            i13 = i10;
        }
        return didiCardProvider2.c(didiAction2, str11, i13, i14, z14, z15, str12, z16, str13, str14, str15, str16, str17, str18, z17, str10);
    }

    private final Context e() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(C3197a.INSTANCE.a());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        return (Context) objB;
    }

    public final Integer A(Integer statusCode) {
        if (statusCode != null && statusCode.intValue() == 0) {
            return 2;
        }
        if (statusCode != null && statusCode.intValue() == 1) {
            return 3;
        }
        if (statusCode != null && statusCode.intValue() == 2) {
            return 4;
        }
        if (statusCode != null && statusCode.intValue() == 4) {
            return 5;
        }
        if (statusCode != null && statusCode.intValue() == 5) {
            return 6;
        }
        if (statusCode != null && statusCode.intValue() == 6) {
            return 7;
        }
        if (statusCode != null && statusCode.intValue() == 7) {
            return 8;
        }
        if (statusCode != null && statusCode.intValue() == 11) {
            return 9;
        }
        return (statusCode != null && statusCode.intValue() == 12) ? 10 : null;
    }

    public final String B(DidiDriverInfo driver) {
        if (driver == null) {
            return null;
        }
        N5.j jVar = N5.j.INSTANCE;
        String strA0 = Z8.F.A0(C1173v.r(jVar.d(Z8.F.A0(C1173v.r(jVar.d(driver.getCarColor()), jVar.d(driver.getCarBrand())), "", null, null, 0, null, null, 62, null)), jVar.d(driver.getCarModel())), " ", null, null, 0, null, null, 62, null);
        if (La.H.x0(strA0)) {
            return null;
        }
        return strA0;
    }

    public final boolean C(TaxiVendorSpec vendor) {
        Object objB;
        if (e() == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(!C3312i.INSTANCE.a(r1, vendor.getPkg())));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    @Override // N5.v
    public N5.d a(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return new DidiCardView(context, null, 0, 6, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009c A[PHI: r3
      0x009c: PHI (r3v16 java.lang.Integer) = (r3v6 java.lang.Integer), (r3v9 java.lang.Integer) binds: [B:32:0x009a, B:38:0x00ae] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0026  */
    @Override // N5.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public N5.n b(N5.CardEnvelope r32) {
        /*
            Method dump skipped, instructions count: 838
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider.b(N5.i):N5.n");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0064 A[PHI: r3
      0x0064: PHI (r3v3 java.lang.String) = (r3v2 java.lang.String), (r3v10 java.lang.String) binds: [B:30:0x004d, B:35:0x005b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardModel.ActionItem c(com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiAction r20, java.lang.String r21, int r22, int r23, boolean r24, boolean r25, java.lang.String r26, boolean r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, boolean r34, java.lang.String r35) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider.c(com.stepos.ailauncher.foundation.appui.card.provider.didi.g, java.lang.String, int, int, boolean, boolean, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String):com.stepos.ailauncher.foundation.appui.card.provider.didi.y$a");
    }

    public final DidiCardModel f(DidiCardModel base, DidiBusinessData d10, DidiAction action, TaxiVendorSpec vendor) {
        DidiAppInfo app;
        DidiAppInfo app2;
        DidiAppInfo app3;
        DidiAppInfo app4;
        DidiAppInfo app5;
        DidiAppInfo app6;
        DidiAppInfo app7;
        DidiAppInfo app8;
        K k10 = K.INSTANCE;
        String appId = null;
        String strD = k10.d(e(), (d10 == null || (app8 = d10.getApp()) == null) ? null : app8.getInstallState(), vendor.getPkg());
        N5.j jVar = N5.j.INSTANCE;
        String strD2 = jVar.d((d10 == null || (app7 = d10.getApp()) == null) ? null : app7.getStoreName());
        if (strD2 == null) {
            strD2 = DEFAULT_STORE_NAME;
        }
        String str = strD2;
        String strD3 = jVar.d((d10 == null || (app6 = d10.getApp()) == null) ? null : app6.getInstallState());
        String strD4 = jVar.d((d10 == null || (app5 = d10.getApp()) == null) ? null : app5.getAppName());
        if (strD4 == null) {
            strD4 = DEFAULT_APP_NAME;
        }
        String strD5 = jVar.d((d10 == null || (app4 = d10.getApp()) == null) ? null : app4.getIconUrl());
        if (strD5 == null) {
            strD5 = jVar.d(d10 != null ? d10.getIconUrl() : null);
        }
        DidiCardModel.AppItem appItem = new DidiCardModel.AppItem(strD4, strD5, jVar.d((d10 == null || (app3 = d10.getApp()) == null) ? null : app3.getSizeText()), jVar.d((d10 == null || (app2 = d10.getApp()) == null) ? null : app2.getExtraText()));
        String strM = a0.INSTANCE.m(strD);
        int i10 = R$drawable.bg_card_didi_cta;
        int i11 = R$color.card_cta_text;
        String strB = k10.b(strD, vendor.getPkg());
        boolean zD = kotlin.jvm.internal.p.d(strD, "installing");
        if (d10 != null && (app = d10.getApp()) != null) {
            appId = app.getAppId();
        }
        return DidiCardModel.c(base, null, 90, false, null, null, null, null, null, null, null, null, null, 0, 0, str, appItem, strD3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, d(this, action, strM, i10, i11, false, false, strB, zD, r(appId, vendor.getPkg()), null, null, "com.stepos.appstore", null, null, false, null, 63024, null), null, null, -114691, 13, null);
    }

    public final List<DidiCardModel.CarTypeItem> g(List<DidiCarType> raw) {
        if (raw == null) {
            raw = C1173v.m();
        }
        List<DidiCarType> list = raw;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            DidiCarType didiCarType = (DidiCarType) obj;
            N5.j jVar = N5.j.INSTANCE;
            String strD = jVar.d(didiCarType.getTypeId());
            if (strD == null && (strD = jVar.d(didiCarType.getName())) == null) {
                strD = "idx" + i10;
            }
            arrayList.add(new DidiCardModel.CarTypeItem(strD, jVar.d(didiCarType.getName()), jVar.d(didiCarType.getPriceText()), a0.INSTANCE.q(didiCarType.getPriceText()), jVar.d(didiCarType.getOriginPriceText()), jVar.d(didiCarType.getImageUrl()), kotlin.jvm.internal.p.d(didiCarType.getSelected(), Boolean.TRUE)));
            i10 = i11;
        }
        return arrayList;
    }

    public final List<DidiCardModel.CarTypeItem> h(List<DidiEstimateItem> items, TaxiVendorSpec vendor) {
        String str;
        String str2;
        boolean z10;
        List<DidiEstimateItem> list = items;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            DidiEstimateItem didiEstimateItem = (DidiEstimateItem) obj;
            N5.j jVar = N5.j.INSTANCE;
            String strD = jVar.d(didiEstimateItem.getProductCategory());
            String strD2 = jVar.d(didiEstimateItem.getProductName());
            if (strD2 != null) {
                str = strD2;
            } else if (strD != null) {
                strD2 = vendor.m().get(strD);
                str = strD2;
            } else {
                str = null;
            }
            String strD3 = jVar.d(didiEstimateItem.getPriceDiscounted());
            if (strD3 == null) {
                strD3 = jVar.d(didiEstimateItem.getPriceText());
            }
            String strD4 = jVar.d(didiEstimateItem.getPriceText());
            if (jVar.d(didiEstimateItem.getPriceDiscounted()) == null) {
                strD4 = null;
            }
            if (strD != null) {
                str2 = strD;
            } else if (str == null) {
                Integer index = didiEstimateItem.getIndex();
                strD = index != null ? String.valueOf(index.intValue()) : null;
                if (strD == null) {
                    strD = "idx" + i10;
                }
                str2 = strD;
            } else {
                str2 = str;
            }
            a0 a0Var = a0.INSTANCE;
            String strK = a0Var.k(strD3, true);
            Double dQ = a0Var.q(strD3);
            String strK2 = a0Var.k(strD4, false);
            Integer defaultDisplay = didiEstimateItem.getDefaultDisplay();
            if (defaultDisplay != null && defaultDisplay.intValue() == 1) {
                z10 = true;
            } else {
                if (defaultDisplay != null) {
                    defaultDisplay.intValue();
                }
                z10 = false;
            }
            arrayList.add(new DidiCardModel.CarTypeItem(str2, str, strK, dQ, strK2, null, z10));
            i10 = i11;
        }
        return arrayList;
    }

    public final DidiCardModel i(DidiCardModel base, DidiBusinessData d10, TaxiVendorSpec vendor) {
        return f(base, d10, null, vendor);
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x03c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardModel j(java.lang.String r82, int r83, com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiBusinessData r84, java.lang.String r85, java.util.List<com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiEstimateItem> r86, N5.CardLinks r87, com.stepos.ailauncher.foundation.appui.card.provider.didi.TaxiVendorSpec r88, java.lang.String r89, java.lang.String r90, java.lang.String r91, java.lang.String r92, java.lang.String r93, java.lang.String r94, java.lang.String r95) {
        /*
            Method dump skipped, instructions count: 1838
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider.j(java.lang.String, int, com.stepos.ailauncher.foundation.appui.card.provider.didi.w, java.lang.String, java.util.List, N5.m, com.stepos.ailauncher.foundation.appui.card.provider.didi.p0, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.stepos.ailauncher.foundation.appui.card.provider.didi.y");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0067 A[PHI: r3
      0x0067: PHI (r3v5 java.lang.String) = (r3v4 java.lang.String), (r3v8 java.lang.String), (r3v11 java.lang.String) binds: [B:13:0x0023, B:24:0x0045, B:29:0x0053] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardModel k(com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardModel r45, com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiBusinessData r46, java.lang.String r47) {
        /*
            r44 = this;
            r0 = r46
            N5.j r1 = N5.j.INSTANCE
            r2 = 0
            if (r0 == 0) goto Lc
            java.lang.String r3 = r0.getTitle()
            goto Ld
        Lc:
            r3 = r2
        Ld:
            java.lang.String r24 = r1.d(r3)
            if (r0 == 0) goto L1e
            com.stepos.ailauncher.foundation.appui.card.provider.didi.S r3 = r0.getPrimaryInfo()
            if (r3 == 0) goto L1e
            java.lang.String r3 = r3.getSubtitle()
            goto L1f
        L1e:
            r3 = r2
        L1f:
            java.lang.String r3 = r1.d(r3)
            if (r3 != 0) goto L67
            if (r0 == 0) goto L40
            java.util.List r3 = r0.G()
            if (r3 == 0) goto L40
            java.lang.Object r3 = Z8.F.s0(r3)
            com.stepos.ailauncher.foundation.appui.card.provider.didi.P r3 = (com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiOrderItem) r3
            if (r3 == 0) goto L40
            com.stepos.ailauncher.foundation.appui.card.provider.didi.S r3 = r3.getPrimaryInfo()
            if (r3 == 0) goto L40
            java.lang.String r3 = r3.getSubtitle()
            goto L41
        L40:
            r3 = r2
        L41:
            java.lang.String r3 = r1.d(r3)
            if (r3 != 0) goto L67
            if (r0 == 0) goto L4e
            java.lang.String r3 = r0.getSubTitle()
            goto L4f
        L4e:
            r3 = r2
        L4f:
            java.lang.String r3 = r1.d(r3)
            if (r3 != 0) goto L67
            if (r0 == 0) goto L5b
            java.lang.String r2 = r0.getNoteText()
        L5b:
            java.lang.String r1 = r1.d(r2)
            if (r1 != 0) goto L64
            r28 = r47
            goto L69
        L64:
            r28 = r1
            goto L69
        L67:
            r28 = r3
        L69:
            java.lang.String r1 = "查看订单"
            r2 = r44
            com.stepos.ailauncher.foundation.appui.card.provider.didi.y$a r38 = r2.x(r0, r1)
            r42 = 13
            r43 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r39 = 0
            r40 = 0
            r41 = -8912897(0xffffffffff77ffff, float:-3.2964852E38)
            r4 = r45
            com.stepos.ailauncher.foundation.appui.card.provider.didi.y r0 = com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardModel.c(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider.k(com.stepos.ailauncher.foundation.appui.card.provider.didi.y, com.stepos.ailauncher.foundation.appui.card.provider.didi.w, java.lang.String):com.stepos.ailauncher.foundation.appui.card.provider.didi.y");
    }

    public final String l(double value) {
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(value)}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        return La.H.G1(La.H.G1(str, '0'), '.');
    }

    public final String m(Double distanceKm) {
        if (distanceKm != null) {
            if (distanceKm.doubleValue() <= 0.0d) {
                distanceKm = null;
            }
            if (distanceKm != null) {
                return l(distanceKm.doubleValue()) + " km";
            }
        }
        return null;
    }

    public final String n(CardEnvelope envelope) {
        N5.j jVar = N5.j.INSTANCE;
        Map<String, Object> mapH = envelope.h();
        Object obj = mapH != null ? mapH.get("message") : null;
        return jVar.d(obj instanceof String ? (String) obj : null);
    }

    public final Pair<String, String> o(List<DidiEstimateItem> items) {
        DidiActionDetail detail;
        DidiActionDetail detail2;
        DidiEstimateItem didiEstimateItem = (DidiEstimateItem) Z8.F.s0(items);
        if (didiEstimateItem == null) {
            return Y8.j.a(null, null);
        }
        N5.j jVar = N5.j.INSTANCE;
        DidiAction action = didiEstimateItem.getAction();
        String strD = jVar.d((action == null || (detail2 = action.getDetail()) == null) ? null : detail2.getAppLink());
        if (strD == null) {
            DidiAction action2 = didiEstimateItem.getAction();
            strD = jVar.d(action2 != null ? action2.getAppLink() : null);
            if (strD == null) {
                DidiActionDetail detail3 = didiEstimateItem.getDetail();
                strD = jVar.d(detail3 != null ? detail3.getAppLink() : null);
            }
        }
        DidiAction action3 = didiEstimateItem.getAction();
        String strD2 = jVar.d((action3 == null || (detail = action3.getDetail()) == null) ? null : detail.getWebLink());
        if (strD2 == null) {
            DidiAction action4 = didiEstimateItem.getAction();
            strD2 = jVar.d(action4 != null ? action4.getWebLink() : null);
            if (strD2 == null) {
                DidiActionDetail detail4 = didiEstimateItem.getDetail();
                strD2 = jVar.d(detail4 != null ? detail4.getWebLink() : null);
            }
        }
        return Y8.j.a(strD, strD2);
    }

    public final String p(DidiBusinessData d10, DidiOrderItem item, String... labels) {
        Object next;
        String value;
        DidiSecondaryInfo secondaryInfo;
        DidiSecondaryInfo secondaryInfo2;
        ArrayList arrayList = new ArrayList();
        for (String str : labels) {
            String strD = N5.j.INSTANCE.d(str);
            if (strD != null) {
                arrayList.add(strD);
            }
        }
        Set setR1 = Z8.F.r1(arrayList);
        List<DidiSecondaryField> listA = (d10 == null || (secondaryInfo2 = d10.getSecondaryInfo()) == null) ? null : secondaryInfo2.a();
        if (listA == null) {
            listA = C1173v.m();
        }
        List<DidiSecondaryField> list = listA;
        List<DidiSecondaryField> listA2 = (item == null || (secondaryInfo = item.getSecondaryInfo()) == null) ? null : secondaryInfo.a();
        if (listA2 == null) {
            listA2 = C1173v.m();
        }
        Iterator it = Z8.F.S0(list, listA2).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Z8.F.f0(setR1, N5.j.INSTANCE.d(((DidiSecondaryField) next).getLabel()))) {
                break;
            }
        }
        DidiSecondaryField didiSecondaryField = (DidiSecondaryField) next;
        if (didiSecondaryField == null || (value = didiSecondaryField.getValue()) == null) {
            return null;
        }
        return N5.j.INSTANCE.d(value);
    }

    public final DidiCardModel.InfoRow q(String label, String value) {
        String strD = N5.j.INSTANCE.d(value);
        if (strD != null) {
            return new DidiCardModel.InfoRow(label, strD);
        }
        return null;
    }

    public final String r(String appId, String pkg) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("market://details?id=");
        sb2.append(pkg);
        sb2.append("&package_name=");
        sb2.append(pkg);
        String strD = N5.j.INSTANCE.d(appId);
        if (strD != null) {
            sb2.append("&app_id=");
            sb2.append(strD);
        }
        sb2.append("&source=");
        sb2.append(MARKET_SOURCE);
        return sb2.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0243 A[PHI: r16
      0x0243: PHI (r16v1 com.stepos.ailauncher.foundation.appui.card.provider.didi.g) = 
      (r16v0 com.stepos.ailauncher.foundation.appui.card.provider.didi.g)
      (r16v4 com.stepos.ailauncher.foundation.appui.card.provider.didi.g)
     binds: [B:134:0x01da, B:138:0x01e5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x03c7 A[PHI: r7
      0x03c7: PHI (r7v10 java.lang.Double) = (r7v9 java.lang.Double), (r7v23 java.lang.Double), (r7v25 java.lang.Double), (r7v26 java.lang.Double) binds: [B:260:0x03af, B:262:0x03b5, B:266:0x03bf, B:268:0x03c3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:281:0x03e8 A[PHI: r7
      0x03e8: PHI (r7v12 java.lang.Double) = (r7v11 java.lang.Double), (r7v18 java.lang.Double), (r7v20 java.lang.Double), (r7v21 java.lang.Double) binds: [B:272:0x03d0, B:274:0x03d6, B:278:0x03e0, B:280:0x03e4] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiBusinessData s(com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiBusinessData r62, int r63, java.lang.String r64, N5.CardLinks r65) {
        /*
            Method dump skipped, instructions count: 1143
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider.s(com.stepos.ailauncher.foundation.appui.card.provider.didi.w, int, java.lang.String, N5.m):com.stepos.ailauncher.foundation.appui.card.provider.didi.w");
    }

    public final String t(int status, String itemEta, Double mapEta) {
        String strD = N5.j.INSTANCE.d(itemEta);
        if (status == 5 && strD != null) {
            String string = La.H.D1(La.H.R0(strD, "剩余行程")).toString();
            return string.length() == 0 ? strD : string;
        }
        if (strD != null) {
            return strD;
        }
        if (mapEta == null) {
            return null;
        }
        return "约" + l(mapEta.doubleValue()) + "分钟到";
    }

    public final String u(DidiBusinessData d10, String taskId) {
        String strR0;
        List<DidiOrderItem> listG;
        DidiOrderItem didiOrderItem = (d10 == null || (listG = d10.G()) == null) ? null : (DidiOrderItem) Z8.F.s0(listG);
        N5.j jVar = N5.j.INSTANCE;
        String strD = jVar.d(d10 != null ? d10.getOrderNo() : null);
        if (strD == null) {
            strD = jVar.d(d10 != null ? d10.getOrderId() : null);
            if (strD == null) {
                strD = jVar.d(didiOrderItem != null ? didiOrderItem.getOrderId() : null);
                if (strD == null) {
                    String strP = p(d10, didiOrderItem, LABEL_ORDER_NO);
                    if (strP != null) {
                        return strP;
                    }
                    if (!La.D.X(taskId, TASK_ID_ORDER_PREFIX, false, 2, null)) {
                        taskId = null;
                    }
                    if (taskId == null || (strR0 = La.H.R0(taskId, TASK_ID_ORDER_PREFIX)) == null) {
                        return null;
                    }
                    return jVar.d(strR0);
                }
            }
        }
        return strD;
    }

    public final DidiCardModel.ActionItem v(DidiBusinessData d10, String fallbackLabel, TaxiVendorSpec vendor, String bizChannel, int status, CardLinks links) {
        boolean z10 = true;
        boolean zL = La.D.L(bizChannel, q0.CAOCAO, true);
        if (status != 3 && status != 4) {
            z10 = false;
        }
        if (zL && z10) {
            return y(d10, fallbackLabel);
        }
        if (zL) {
            return null;
        }
        return z(d10, fallbackLabel, links, vendor);
    }

    public final String w(String text) {
        La.m mVar;
        List<String> listC;
        String strD = N5.j.INSTANCE.d(text);
        if (strD == null || (mVar = (La.m) SequencesKt___SequencesKt.Q(Regex.f(PHONE_SUFFIX_REGEX, strD, 0, 2, null))) == null || (listC = mVar.c()) == null) {
            return null;
        }
        return (String) Z8.F.t0(listC, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0039 A[PHI: r2
      0x0039: PHI (r2v3 java.lang.String) = (r2v2 java.lang.String), (r2v5 java.lang.String) binds: [B:13:0x0022, B:19:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardModel.ActionItem x(com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiBusinessData r22, java.lang.String r23) {
        /*
            r21 = this;
            r0 = 0
            if (r22 == 0) goto L9
            com.stepos.ailauncher.foundation.appui.card.provider.didi.g r1 = r22.getAction()
            r3 = r1
            goto La
        L9:
            r3 = r0
        La:
            int r5 = com.stepos.ailauncher.foundation.R$drawable.bg_card_didi_cta
            int r6 = com.stepos.ailauncher.foundation.R$color.card_cta_text
            N5.j r1 = N5.j.INSTANCE
            if (r22 == 0) goto L1d
            com.stepos.ailauncher.foundation.appui.card.provider.didi.g r2 = r22.getAction()
            if (r2 == 0) goto L1d
            java.lang.String r2 = r2.getReplyText()
            goto L1e
        L1d:
            r2 = r0
        L1e:
            java.lang.String r2 = r1.d(r2)
            if (r2 != 0) goto L39
            if (r22 == 0) goto L30
            com.stepos.ailauncher.foundation.appui.card.provider.didi.g r2 = r22.getAction()
            if (r2 == 0) goto L30
            java.lang.String r0 = r2.getLabel()
        L30:
            java.lang.String r2 = r1.d(r0)
            if (r2 != 0) goto L39
            r18 = r23
            goto L3b
        L39:
            r18 = r2
        L3b:
            r19 = 16368(0x3ff0, float:2.2936E-41)
            r20 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 1
            r2 = r21
            r4 = r23
            com.stepos.ailauncher.foundation.appui.card.provider.didi.y$a r0 = d(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider.x(com.stepos.ailauncher.foundation.appui.card.provider.didi.w, java.lang.String):com.stepos.ailauncher.foundation.appui.card.provider.didi.y$a");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004f A[PHI: r2
      0x004f: PHI (r2v3 java.lang.String) = (r2v2 java.lang.String), (r2v4 java.lang.String) binds: [B:15:0x0038, B:21:0x004a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardModel.ActionItem y(com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiBusinessData r23, java.lang.String r24) {
        /*
            r22 = this;
            r0 = 0
            if (r23 == 0) goto L1f
            com.stepos.ailauncher.foundation.appui.card.provider.didi.g r1 = r23.getAction()
            if (r1 == 0) goto L1f
            com.stepos.ailauncher.foundation.appui.card.provider.didi.g r2 = new com.stepos.ailauncher.foundation.appui.card.provider.didi.g
            java.lang.String r4 = r1.getLabel()
            java.lang.String r5 = r1.getReplyText()
            r9 = 57
            r10 = 0
            r3 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r4 = r2
            goto L20
        L1f:
            r4 = r0
        L20:
            int r6 = com.stepos.ailauncher.foundation.R$drawable.bg_card_didi_cta
            int r7 = com.stepos.ailauncher.foundation.R$color.card_cta_text
            N5.j r1 = N5.j.INSTANCE
            if (r23 == 0) goto L33
            com.stepos.ailauncher.foundation.appui.card.provider.didi.g r2 = r23.getAction()
            if (r2 == 0) goto L33
            java.lang.String r2 = r2.getReplyText()
            goto L34
        L33:
            r2 = r0
        L34:
            java.lang.String r2 = r1.d(r2)
            if (r2 != 0) goto L4f
            if (r23 == 0) goto L46
            com.stepos.ailauncher.foundation.appui.card.provider.didi.g r2 = r23.getAction()
            if (r2 == 0) goto L46
            java.lang.String r0 = r2.getLabel()
        L46:
            java.lang.String r2 = r1.d(r0)
            if (r2 != 0) goto L4f
            r19 = r24
            goto L51
        L4f:
            r19 = r2
        L51:
            r20 = 16368(0x3ff0, float:2.2936E-41)
            r21 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 1
            r3 = r22
            r5 = r24
            com.stepos.ailauncher.foundation.appui.card.provider.didi.y$a r0 = d(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider.y(com.stepos.ailauncher.foundation.appui.card.provider.didi.w, java.lang.String):com.stepos.ailauncher.foundation.appui.card.provider.didi.y$a");
    }

    public final DidiCardModel.ActionItem z(DidiBusinessData d10, String fallbackLabel, CardLinks links, TaxiVendorSpec vendor) {
        DidiAction action;
        return d(this, (d10 == null || (action = d10.getAction()) == null) ? null : new DidiAction(null, action.getLabel(), null, null, null, null, 61, null), fallbackLabel, R$drawable.bg_card_didi_cta, R$color.card_cta_text, false, false, null, false, N5.j.INSTANCE.d(links != null ? links.getApp() : null), null, vendor.getPkg(), null, null, null, false, null, 64240, null);
    }
}
