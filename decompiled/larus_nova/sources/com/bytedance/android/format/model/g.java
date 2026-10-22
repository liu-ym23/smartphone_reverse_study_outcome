package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.segment.Segment;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/format/model/g;", "", "", "ak", "Ljava/lang/String;", "getAk", "()Ljava/lang/String;", "setAk", "(Ljava/lang/String;)V", "sk", "getSk", "setSk", Segment.JsonKey.START, "getSt", "setSt", "expiredTime", "getExpiredTime", "setExpiredTime", "currentTime", "getCurrentTime", "setCurrentTime", "spaceName", "getSpaceName", "setSpaceName", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    /* JADX INFO: renamed from: ak, reason: collision with root package name */
    @SerializedName("access_key_id")
    private String f51348ak;

    @SerializedName("current_time")
    private String currentTime;

    @SerializedName("expired_time")
    private String expiredTime;

    /* JADX INFO: renamed from: sk, reason: collision with root package name */
    @SerializedName("secret_access_key")
    private String f51349sk;

    @SerializedName("space_name")
    private String spaceName;

    /* JADX INFO: renamed from: st, reason: collision with root package name */
    @SerializedName("session_token")
    private String f51350st;

    public g() {
    }
}
