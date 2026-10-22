package com.android.ttcjpaysdk.base.framework.manager;

import android.content.SharedPreferences;
import com.android.ttcjpaysdk.base.ktextension.SharedPrefExtKt;
import com.lynx.serval.svg.SVGRenderEngine;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.download.api.constant.BaseConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/manager/CJPayScreenshotMessage;", "", "()V", "countList", "", "", "screenshotPage", "screenshotTime", "getMessage", SVGRenderEngine.SAVE, "", "page", "", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayScreenshotMessage {
    private static final String COUNT_SEPARATOR = ",";
    public static final Companion Companion = null;
    private static final String KEY_SCREENSHOT_COUNT = "screenshot_count_24h";
    private static final String KEY_SCREENSHOT_PAGE = "screenshot_page";
    private static final String KEY_SCREENSHOT_TIME = "screenshot_time";
    private static final String SCREENSHOT_MESSAGE_SP = "screenshot_message_sp";
    private static final Lazy<SimpleDateFormat> dateFormat$delegate = null;
    private static final Lazy<SharedPreferences> sp$delegate = null;
    private List<String> countList;
    private String screenshotPage;
    private String screenshotTime;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/manager/CJPayScreenshotMessage$Companion;", "", "()V", "COUNT_SEPARATOR", "", "KEY_SCREENSHOT_COUNT", "KEY_SCREENSHOT_PAGE", "KEY_SCREENSHOT_TIME", "SCREENSHOT_MESSAGE_SP", "dateFormat", "Ljava/text/SimpleDateFormat;", "getDateFormat", "()Ljava/text/SimpleDateFormat;", "dateFormat$delegate", "Lkotlin/Lazy;", CloudControlInf.SP, "Landroid/content/SharedPreferences;", "getSp", "()Landroid/content/SharedPreferences;", "sp$delegate", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final SimpleDateFormat getDateFormat() {
            return (SimpleDateFormat) CJPayScreenshotMessage.access$getDateFormat$delegate$cp().getValue();
        }

        private final SharedPreferences getSp() {
            return (SharedPreferences) CJPayScreenshotMessage.access$getSp$delegate$cp().getValue();
        }

        public static final /* synthetic */ SimpleDateFormat access$getDateFormat(Companion r100) {
            return r100.getDateFormat();
        }

        public static final /* synthetic */ SharedPreferences access$getSp(Companion r100) {
            return r100.getSp();
        }
    }

    static {
        Companion = new Companion(null);
        sp$delegate = LazyKt.lazy(CJPayScreenshotMessage$Companion$sp$2.INSTANCE);
        dateFormat$delegate = LazyKt.lazy(CJPayScreenshotMessage$Companion$dateFormat$2.INSTANCE);
    }

    public final String getMessage() {
        boolean r100 = true;
        if (this.screenshotPage.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
    L14:
        return "";
    L8:
        if (this.screenshotTime.length() == 0) goto L11;
        r100 = false;
    L11:
        if (r100 == true) goto L14;
        JSONObject r102 = new JSONObject();
        r102.put(KEY_SCREENSHOT_PAGE, this.screenshotPage);
        r102.put(KEY_SCREENSHOT_TIME, this.screenshotTime);
        JSONObject r103 = new JSONObject();
        r103.put("latest_screenshot_message", r102.toString());
        r103.put(KEY_SCREENSHOT_COUNT, this.countList.size());
        return r103.toString();
    L5:
        r101 = false;
        goto L6
    }

    public CJPayScreenshotMessage() {
        this.screenshotPage = "";
        this.screenshotTime = "";
        this.countList = new ArrayList();
        Companion r100 = Companion;
        String r101 = Companion.access$getSp(r100).getString(KEY_SCREENSHOT_PAGE, "");
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.screenshotPage = r101;
        String r102 = Companion.access$getSp(r100).getString(KEY_SCREENSHOT_TIME, "");
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        this.screenshotTime = r102;
        String r103 = Companion.access$getSp(r100).getString(KEY_SCREENSHOT_COUNT, "");
        if (r103 != null) goto L11;
        return;
    L11:
        if ((!StringsKt.isBlank(r103)) == true) goto L14;
        r103 = null;
    L14:
        String r104 = r103;
        if (r104 == null) goto L37;
        long r105 = System.currentTimeMillis() - ((long) BaseConstants.Time.DAY);
        List r106 = StringsKt.split$default(r104, new String[]{","}, false, 0, 6, null);
        ArrayList r107 = new ArrayList();
        Iterator r108 = r106.iterator();
    L18:
        if (r108.hasNext() == false) goto L29;
        Object r109 = r108.next();
        Long r110 = StringsKt.toLongOrNull((String) r109);
        if (r110 == null) goto L22;
        long r111 = r110.longValue();
    L24:
        if (r111 <= r105) goto L26;
        boolean r112 = true;
    L27:
        if (r112 == false) goto L18;
        r107.add(r109);
        goto L18
    L26:
        r112 = false;
        goto L27
    L22:
        r111 = -1;
        goto L24
    L29:
        this.countList = CollectionsKt.toMutableList(r107);
        return;
    }

    public static final /* synthetic */ Lazy access$getDateFormat$delegate$cp() {
        return dateFormat$delegate;
    }

    public static final /* synthetic */ Lazy access$getSp$delegate$cp() {
        return sp$delegate;
    }

    public static final /* synthetic */ List access$getCountList$p(CJPayScreenshotMessage r100) {
        return r100.countList;
    }

    public static final /* synthetic */ String access$getScreenshotPage$p(CJPayScreenshotMessage r100) {
        return r100.screenshotPage;
    }

    public static final /* synthetic */ String access$getScreenshotTime$p(CJPayScreenshotMessage r100) {
        return r100.screenshotTime;
    }

    public final void save(int r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        this.screenshotPage = String.valueOf(r100);     // Catch: Throwable -> L4
        Companion r102 = Companion;     // Catch: Throwable -> L4
        this.screenshotTime = Companion.access$getDateFormat(r102).format(Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L4
        this.countList.add(String.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L4
        SharedPrefExtKt.edit(Companion.access$getSp(r102), new CJPayScreenshotMessage$save$1$1(this));     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
