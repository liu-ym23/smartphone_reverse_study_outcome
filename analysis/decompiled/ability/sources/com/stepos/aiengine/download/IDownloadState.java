package com.stepos.aiengine.download;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/stepos/aiengine/download/IDownloadState;", "", "", "STATUS_NONE", "I", "STATUS_WAITING", "STATUS_STARTED", "STATUS_ERROR", "STATUS_PAUSED", "STATUS_CHECKING", "STATUS_FINISHED", "STATUS_REMOVED", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class IDownloadState {
    public static final IDownloadState INSTANCE = new IDownloadState();
    public static final int STATUS_CHECKING = 5;
    public static final int STATUS_ERROR = 3;
    public static final int STATUS_FINISHED = 6;
    public static final int STATUS_NONE = 0;
    public static final int STATUS_PAUSED = 4;
    public static final int STATUS_REMOVED = 7;
    public static final int STATUS_STARTED = 2;
    public static final int STATUS_WAITING = 1;
}
