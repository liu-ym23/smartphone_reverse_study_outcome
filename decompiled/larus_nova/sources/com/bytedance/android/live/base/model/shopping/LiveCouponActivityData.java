package com.bytedance.android.live.base.model.shopping;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\u0004J\b\u0010\u0019\u001a\u0004\u0018\u00010\nJ\b\u0010\u001a\u001a\u0004\u0018\u00010\nJ\b\u0010\u001b\u001a\u0004\u0018\u00010\nJ\b\u0010\u001c\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0004J\u0010\u0010 \u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010\nJ\u0010\u0010\"\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010\nJ\u0010\u0010$\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010\nJ\u0010\u0010&\u001a\u00020\u001e2\b\u0010'\u001a\u0004\u0018\u00010\nR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR \u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR \u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006("}, d2 = {"Lcom/bytedance/android/live/base/model/shopping/LiveCouponActivityData;", "", "()V", "_activityType", "", "get_activityType", "()J", "set_activityType", "(J)V", "_afterButton", "", "get_afterButton", "()Ljava/lang/String;", "set_afterButton", "(Ljava/lang/String;)V", "_afterText", "get_afterText", "set_afterText", "_beforeButton", "get_beforeButton", "set_beforeButton", "_beforeText", "get_beforeText", "set_beforeText", "getActivityType", "getAfterButton", "getAfterText", "getBeforeButton", "getBeforeText", "setActivityType", "", "activityType", "setAfterButton", "afterButton", "setAfterText", "afterText", "setBeforeButton", "beforeButton", "setBeforeText", "beforeText", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCouponActivityData {

    @SerializedName(a.KEY_ACTIVITY_TYPE)
    private long _activityType;

    @SerializedName("after_button")
    private String _afterButton;

    @SerializedName("after_text")
    private String _afterText;

    @SerializedName("before_button")
    private String _beforeButton;

    @SerializedName("before_text")
    private String _beforeText;

    public LiveCouponActivityData() {
    }

    public final long getActivityType() {
        return this._activityType;
    }

    public final String getAfterButton() {
        return this._afterButton;
    }

    public final String getAfterText() {
        return this._afterText;
    }

    public final String getBeforeButton() {
        return this._beforeButton;
    }

    public final String getBeforeText() {
        return this._beforeText;
    }

    public final long get_activityType() {
        return this._activityType;
    }

    public final String get_afterButton() {
        return this._afterButton;
    }

    public final String get_afterText() {
        return this._afterText;
    }

    public final String get_beforeButton() {
        return this._beforeButton;
    }

    public final String get_beforeText() {
        return this._beforeText;
    }

    public final void setActivityType(long r100) {
        this._activityType = r100;
    }

    public final void setAfterButton(String r100) {
        this._afterButton = r100;
    }

    public final void setAfterText(String r100) {
        this._afterText = r100;
    }

    public final void setBeforeButton(String r100) {
        this._beforeButton = r100;
    }

    public final void setBeforeText(String r100) {
        this._beforeText = r100;
    }

    public final void set_activityType(long r100) {
        this._activityType = r100;
    }

    public final void set_afterButton(String r100) {
        this._afterButton = r100;
    }

    public final void set_afterText(String r100) {
        this._afterText = r100;
    }

    public final void set_beforeButton(String r100) {
        this._beforeButton = r100;
    }

    public final void set_beforeText(String r100) {
        this._beforeText = r100;
    }
}
