package com.obric.aikernel.sdk.ext;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.sdk.config.RequestParams;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: Params.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ParamsKt {
    public static final void setPreloadSeconds(RequestParams r3, int r4) {
        o.e(r3, "<this>");
        r3.getBackend().putBoolean(Params.NEED_PRELOAD, true);
        r3.getBackend().putInt(Params.PRELOAD_SECONDS, r4);
    }

    public static final void setLora(RequestParams r1, String r2) {
        o.e(r1, "<this>");
        o.e(r2, "type");
        r1.getBackend().putString(Params.LORA_TYPE, r2);
    }

    public static final void setVlm2_0(RequestParams r2, String r3, String r4) {
        o.e(r2, "<this>");
        o.e(r3, Params.PROMPT);
        o.e(r4, "uri");
        r2.getBackend().putString(Params.PROMPT, r3);
        setFilePath(r2, r4);
        useCloudModel$default(r2, null, 1, null);
    }

    public static final void setCloudChatModel(RequestParams r2, String r3) {
        o.e(r2, "<this>");
        o.e(r3, "content");
        useCloudModel$default(r2, null, 1, null);
        setTextModelInput(r2, r3);
    }

    public static /* synthetic */ void useCloudModel$default(RequestParams r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        useCloudModel(r0, r1);
    }

    public static final void useCloudModel(RequestParams r2, String r3) {
        o.e(r2, "<this>");
        if (r3 == null) goto L5;
        r2.getBackend().putString("version", r3);
    L5:
        r2.getBackend().putBoolean("useCloud", true);
    }

    public static final void setTextModelInput(RequestParams r1, String r2) {
        o.e(r1, "<this>");
        o.e(r2, "content");
        r1.getBackend().putString("content", r2);
    }

    public static final void setMemoryTextEmbeddingV2(RequestParams r1, String r2) {
        o.e(r1, "<this>");
        o.e(r2, "content");
        setTextModelInput(r1, r2);
    }

    public static final void setFilePath(RequestParams r1, String r2) {
        o.e(r1, "<this>");
        o.e(r2, Params.FILE_PATH);
        r1.getBackend().putString(Params.FILE_PATH, r2);
    }

    public static final void authFilePath(RequestParams r4, Context r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "<this>");
        o.e(r7, "context");
        o.e(r6, Params.FILE_PATH);
        r7.grantUriPermission("com.obric.aikernel", Uri.parse(r6), 1);
        r4.getBackend().putString(Params.FILE_PATH, r6);
    }

    public static final void setAssetFd(RequestParams r2, String r3, AssetFileDescriptor r4) {
        o.e(r2, "<this>");
        o.e(r3, DownloadConstants.PATH_KEY);
        o.e(r4, "fd");
        setFilePath(r2, r3);
        r2.getBackend().putParcelable(Params.FD_ASSET, (Parcelable) ZeusTransformUtils.preCheckCast(r4, Parcelable.class, "com.obric.aiagent.plugin"));
        ParcelFileDescriptor r5 = r4.getParcelFileDescriptor();
        o.c(r5, "fd.parcelFileDescriptor");
        setFileFd(r2, r5);
    }

    public static final void setCustomArgs(RequestParams r2, b<? super Bundle, x> r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        o.e(r2, "<this>");
        o.e(r4, "block");
        r4.invoke(r2.getBackend());
    }

    public static final void setFileFd(RequestParams r2, ParcelFileDescriptor r3) {
        o.e(r2, "<this>");
        o.e(r3, "fd");
        r2.getBackend().putParcelable(Params.FD, (Parcelable) ZeusTransformUtils.preCheckCast(r3, Parcelable.class, "com.obric.aiagent.plugin"));
    }

    public static final void setUpdateParams(RequestParams r1, boolean r2) {
        o.e(r1, "<this>");
        r1.getBackend().putBoolean(Params.UPDATE_CONFIG, r2);
    }

    public static final void setInferEvent(RequestParams r1, String r2) {
        o.e(r1, "<this>");
        o.e(r2, "event");
        r1.getBackend().putString(IdlKeys.Args_Infer_Event, r2);
    }
}
