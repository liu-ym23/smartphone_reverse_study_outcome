package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u001c\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR$\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\b¨\u0006%"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/u;", "", "", "user_type", "Ljava/lang/Integer;", "getUser_type", "()Ljava/lang/Integer;", "setUser_type", "(Ljava/lang/Integer;)V", "", "game_launch_count", "Ljava/lang/String;", "getGame_launch_count", "()Ljava/lang/String;", "setGame_launch_count", "(Ljava/lang/String;)V", "total_game_duration", "getTotal_game_duration", "setTotal_game_duration", "current_game_duration", "getCurrent_game_duration", "setCurrent_game_duration", "enter_method_no_from", "getEnter_method_no_from", "setEnter_method_no_from", "desktop_entrance_status", "getDesktop_entrance_status", "setDesktop_entrance_status", "download_btn_status", "getDownload_btn_status", "setDownload_btn_status", "free_storage_space", "getFree_storage_space", "setFree_storage_space", "can_download_full_game", "getCan_download_full_game", "setCan_download_full_game", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u {

    @SerializedName("can_download_full_game")
    private Integer can_download_full_game;

    @SerializedName("current_game_duration")
    private String current_game_duration;

    @SerializedName("desktop_entrance_status")
    private Integer desktop_entrance_status;

    @SerializedName("download_btn_status")
    private String download_btn_status;

    @SerializedName("enter_method_no_from")
    private String enter_method_no_from;

    @SerializedName("free_storage_space")
    private String free_storage_space;

    @SerializedName("game_launch_count")
    private String game_launch_count;

    @SerializedName("total_game_duration")
    private String total_game_duration;

    @SerializedName("user_type")
    private Integer user_type;

    public u() {
        this.user_type = null;
        this.game_launch_count = null;
        this.total_game_duration = null;
        this.current_game_duration = null;
        this.enter_method_no_from = null;
        this.desktop_entrance_status = null;
        this.download_btn_status = null;
        this.free_storage_space = null;
        this.can_download_full_game = null;
    }
}
