package com.android.ttcjpaysdk.bdpay.counter.outer.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/ConfirmNextAction;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "action_type", "", "load_prompt", DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNWON_SOURCE_QUERY_INTERVAL, "query_times", "needQuery", "", "Companion", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ConfirmNextAction implements CJPayObject, Serializable {
    public static final String ACTION_TYPE_QUERY = "QUERY";
    public static final Companion Companion = null;
    public static final int DEFAULT_QUERY_TIMES = 5;
    public String action_type;
    public String load_prompt;
    public String query_interval;
    public String query_times;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/ConfirmNextAction$Companion;", "", "()V", "ACTION_TYPE_QUERY", "", "DEFAULT_QUERY_TIMES", "", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final boolean needQuery() {
        return Intrinsics.areEqual(ACTION_TYPE_QUERY, this.action_type);
    }

    public ConfirmNextAction() {
        this.action_type = "";
        this.query_times = "5";
        this.query_interval = "500";
        this.load_prompt = "";
    }
}
