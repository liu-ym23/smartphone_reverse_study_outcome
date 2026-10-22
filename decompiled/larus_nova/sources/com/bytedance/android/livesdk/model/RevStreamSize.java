package com.bytedance.android.livesdk.model;

import com.bytedance.android.livesdkapi.broadcastgame.GameSeiConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/model/RevStreamSize;", "", "()V", "gameRatio", "", "getGameRatio", "()D", "setGameRatio", "(D)V", "h", "getH", "setH", "w", "getW", "setW", "x", "getX", "setX", "y", "getY", "setY", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevStreamSize {

    @SerializedName(GameSeiConstants.KEY_GAME_RATIO)
    private double gameRatio;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SerializedName("h")
    private double f153919h;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @SerializedName("w")
    private double f153920w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    private double f153921x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    private double f153922y;

    public RevStreamSize() {
    }

    public final double getGameRatio() {
        return this.gameRatio;
    }

    public final double getH() {
        return this.f153919h;
    }

    public final double getW() {
        return this.f153920w;
    }

    public final double getX() {
        return this.f153921x;
    }

    public final double getY() {
        return this.f153922y;
    }

    public final void setGameRatio(double r100) {
        this.gameRatio = r100;
    }

    public final void setH(double r100) {
        this.f153919h = r100;
    }

    public final void setW(double r100) {
        this.f153920w = r100;
    }

    public final void setX(double r100) {
        this.f153921x = r100;
    }

    public final void setY(double r100) {
        this.f153922y = r100;
    }
}
