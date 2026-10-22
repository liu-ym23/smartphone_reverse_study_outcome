package com.android.ttcjpaysdk.base.service.bean;

import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eBG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rR\"\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/bean/ALogReportConfig;", "", "report_enable", "", "event_white_list", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "report_time_interval", "", "report_enable_interval", "last_upload_interval", "", "(ZLjava/util/ArrayList;IIJ)V", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ALogReportConfig {
    public static final Companion Companion = null;
    public ArrayList<String> event_white_list;
    public long last_upload_interval;
    public boolean report_enable;
    public int report_enable_interval;
    public int report_time_interval;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/bean/ALogReportConfig$Companion;", "", "()V", "fromJson", "Lcom/android/ttcjpaysdk/base/service/bean/ALogReportConfig;", "jsonString", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final ALogReportConfig fromJson(String r110) {
            Intrinsics.checkNotNullParameter(r110, "jsonString");
            ALogReportConfig r100 = new ALogReportConfig(false, null, 0, 0, 0, 31, null);
            JSONObject r101 = new JSONObject(r110);     // Catch: Exception -> L8
            r100.report_enable = r101.optBoolean("report_enable");     // Catch: Exception -> L8
            JSONArray r111 = r101.optJSONArray("event_white_list");     // Catch: Exception -> L8
            if (r111 == null) goto L6;
            ReuseHostDomainKt.toStringList(r111, r100.event_white_list);     // Catch: Exception -> L8
        L6:
            r100.report_time_interval = r101.optInt("report_time_interval");     // Catch: Exception -> L8
            r100.report_enable_interval = r101.optInt("report_enable_interval");     // Catch: Exception -> L8
        L10:
            return r100;
        L8:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("ALogReportConfig#ALogReportConfig", e);
            CJBasicCommonUtils.logCatch("CJCatch", "ALogReportConfig#ALogReportConfig", e);
            goto L10
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ALogReportConfig() {
        this(false, null, 0, 0, 0, 31, null);
    }

    @JvmStatic
    public static final ALogReportConfig fromJson(String r100) {
        return Companion.fromJson(r100);
    }

    public ALogReportConfig(boolean r100, ArrayList<String> r101, int r102, int r103, long r104) {
        Intrinsics.checkNotNullParameter(r101, "event_white_list");
        this.report_enable = r100;
        this.event_white_list = r101;
        this.report_time_interval = r102;
        this.report_enable_interval = r103;
        this.last_upload_interval = r104;
    }

    public /* synthetic */ ALogReportConfig(boolean r100, ArrayList r101, int r102, int r103, long r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r110 & 2) == 0) goto L8;
        r101 = new ArrayList();
    L8:
        ArrayList r112 = r101;
        if ((r110 & 4) == 0) goto L11;
        int r105 = 600;
    L13:
        if ((r110 & 8) == 0) goto L15;
        int r106 = AnnouncementViewModel.HOUR_DURATION;
    L17:
        if ((r110 & 16) == 0) goto L19;
        r104 = 0;
    L19:
        long r107 = r104;
        this(r100, r112, r105, r106, r107);
        return;
    L15:
        r106 = r103;
        goto L17
    L11:
        r105 = r102;
        goto L13
    }
}
