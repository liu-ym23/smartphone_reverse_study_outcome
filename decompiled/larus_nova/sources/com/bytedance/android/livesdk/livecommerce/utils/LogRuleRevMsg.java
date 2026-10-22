package com.bytedance.android.livesdk.livecommerce.utils;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\f\u0010\rJ\n\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/utils/LogRuleRevMsg;", "Lcom/bytedance/android/livesdk/livecommerce/utils/LogRule;", "parse", "", "getIntrinsicOn", "", "msgType", "", "isHandleMsgType", "Ljava/util/HashSet;", "msgTypeSet", "Ljava/util/HashSet;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
final class LogRuleRevMsg extends LogRule {
    public static final a Companion = null;
    public static final String RULE_STR_REV_MSG = "recv_msg";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f153051a = null;
    private final HashSet<Integer> msgTypeSet;

    public static final class a {
        public a() {
        }
    }

    @Override // com.bytedance.android.livesdk.livecommerce.utils.LogRule
    public String getIntrinsicOn() {
        return RULE_STR_REV_MSG;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.utils.LogRule
    public LogRule parse() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L16
        Companion.getClass();     // Catch: Throwable -> L16
        Regex r101 = (Regex) access$getRULE_REV_MSG_REGEX$cp().getValue();     // Catch: Throwable -> L16
        String r102 = getOn();     // Catch: Throwable -> L16
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        MatchResult r103 = Regex.find$default(r101, r102, 0, 2, null);     // Catch: Throwable -> L16
        if (r103 == null) goto L13;
        Iterator r104 = StringsKt.split$default((String) ListProtector.get(r103.getDestructured().getMatch().getGroupValues(), 1), new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null).iterator();     // Catch: Throwable -> L16
    L10:
        if (r104.hasNext() == false) goto L12;
        this.msgTypeSet.add(Integer.valueOf(CastIntegerProtector.parseInt((String) r104.next())));     // Catch: Throwable -> L16
        goto L10
    L12:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L14:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L16
    L19:
        if (this.msgTypeSet.size() > 0) goto L21;
        return null;
    L21:
        return this;
    L13:
        r105 = null;
    L16:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    static {
        Companion = new a();
        f153051a = LazyKt.lazy(LogRuleRevMsg$Companion$RULE_REV_MSG_REGEX$2.INSTANCE);
    }

    public LogRuleRevMsg() {
        this.msgTypeSet = new HashSet();
    }

    public static final /* synthetic */ Lazy access$getRULE_REV_MSG_REGEX$cp() {
        return f153051a;
    }

    public final boolean isHandleMsgType(int r100) {
        return this.msgTypeSet.contains(Integer.valueOf(r100));
    }
}
