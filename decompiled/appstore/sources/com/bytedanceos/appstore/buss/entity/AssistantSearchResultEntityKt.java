package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toAppInfo", "Lcom/bytedanceos/common/model/AppInfo;", "Lcom/bytedanceos/appstore/buss/entity/AssistantSearchResultEntity;", "app_sysapp_updateRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAssistantSearchResultEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AssistantSearchResultEntity.kt\ncom/bytedanceos/appstore/buss/entity/AssistantSearchResultEntityKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,76:1\n1#2:77\n*E\n"})
public final class AssistantSearchResultEntityKt {
    @NotNull
    public static final AppInfo toAppInfo(@NotNull AssistantSearchResultEntity r10) {
        q.g(r10, "<this>");
        AppInfo r11 = new AppInfo();
        r11.appId = r10.getId();
        r11.appName = r10.getName();
        r11.fileMd5 = r10.getFilemd5();
        Result.a r12 = Result.Companion;     // Catch: Throwable -> L6
        String r13 = r10.getVersion_code();     // Catch: Throwable -> L6
        if (r13 == null) goto L8;
        int r14 = Integer.parseInt(r13);     // Catch: Throwable -> L6
    L9:
        Object r15 = Result.m35constructorimpl(Integer.valueOf(r14));     // Catch: Throwable -> L6
    L13:
        if (Result.m41isFailureimpl(r15) == false) goto L15;
        r15 = -1;
    L15:
        r11.appVersionCode = ((Number) r15).intValue();
        r11.appVersionName = r10.getVersion();
        r11.appPackageName = r10.getPkg();
        r11.appIcon = r10.getLogo();
        String r16 = r10.getScores();     // Catch: Throwable -> L19
        if (r16 == null) goto L21;
        float r17 = Float.parseFloat(r16);     // Catch: Throwable -> L19
    L22:
        Object r18 = Result.m35constructorimpl(Float.valueOf(r17));     // Catch: Throwable -> L19
    L25:
        Float r19 = Float.valueOf(0.0f);
        if (Result.m41isFailureimpl(r18) == false) goto L28;
        r18 = r19;
    L28:
        r11.appScores = ((Number) r18).floatValue();
        r11.appCategoryName = r10.getCategory();
        String r20 = r10.getFilesize();     // Catch: Throwable -> L32
        if (r20 == null) goto L34;
        long r21 = Long.parseLong(r20);     // Catch: Throwable -> L32
    L35:
        Object r22 = Result.m35constructorimpl(Long.valueOf(r21));     // Catch: Throwable -> L32
    L39:
        if (Result.m41isFailureimpl(r22) == false) goto L41;
        r22 = 0L;
    L41:
        r11.appBytes = ((Number) r22).longValue();
        String r23 = r10.getStatus();     // Catch: Throwable -> L45
        if (r23 == null) goto L47;
        int r24 = Integer.parseInt(r23);     // Catch: Throwable -> L45
    L48:
        Object r25 = Result.m35constructorimpl(Integer.valueOf(r24));     // Catch: Throwable -> L45
    L52:
        if (Result.m41isFailureimpl(r25) == false) goto L54;
        r25 = -1;
    L54:
        r11.mStatus = ((Number) r25).intValue();
        r11.mIsNeedGms = q.b(r10.getIfgms(), "1");
        r11.appDownloadUrl = r10.getDownload_url();
        r11.recmd_brief = r10.getRecmd_brief();
        String r26 = r10.getSoft_type();     // Catch: Throwable -> L58
        if (r26 == null) goto L60;
        int r27 = Integer.parseInt(r26);     // Catch: Throwable -> L58
    L61:
        Object r28 = Result.m35constructorimpl(Integer.valueOf(r27));     // Catch: Throwable -> L58
    L65:
        if (Result.m41isFailureimpl(r28) == false) goto L67;
        r28 = 0;
    L67:
        r11.mAppType = ((Number) r28).intValue();
        r11.appSource = "local";
        r11.mLabels = new ArrayList();     // Catch: NumberFormatException -> L72
        List<Integer> r29 = r10.getLabel();     // Catch: NumberFormatException -> L72
        if (r29 == null) goto L74;
        r11.mLabels.addAll(r29);     // Catch: NumberFormatException -> L72
    L74:
        return r11;
    L72:
        e = move-exception;
        e.printStackTrace();
        goto L74
    L60:
        r27 = 0;
    L58:
        th = move-exception;
        Result.a r30 = Result.Companion;
        r28 = Result.m35constructorimpl(c.a(th));
        goto L65
    L47:
        r24 = -1;
    L45:
        th = move-exception;
        Result.a r31 = Result.Companion;
        r25 = Result.m35constructorimpl(c.a(th));
        goto L52
    L34:
        r21 = 0;
    L32:
        th = move-exception;
        Result.a r32 = Result.Companion;
        r22 = Result.m35constructorimpl(c.a(th));
        goto L39
    L21:
        r17 = 0.0f;
    L19:
        th = move-exception;
        Result.a r33 = Result.Companion;
        r18 = Result.m35constructorimpl(c.a(th));
        goto L25
    L8:
        r14 = -1;
    L6:
        th = move-exception;
        Result.a r34 = Result.Companion;
        r15 = Result.m35constructorimpl(c.a(th));
        goto L13
    }
}
