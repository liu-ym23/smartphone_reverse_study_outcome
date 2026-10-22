package com.bytedanceos.common.networkv2.entity;

/* JADX INFO: loaded from: classes2.dex */
public class AccountUserBean {
    private int active;
    private String avatar;
    private String avatar_url;
    private String cellphone;
    private String email;
    private long last_update;
    private String nickname;
    private long uid;

    public AccountUserBean() {
    }

    public int getActive() {
        return this.active;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getAvatar_url() {
        return this.avatar_url;
    }

    public String getCellphone() {
        return this.cellphone;
    }

    public String getEmail() {
        return this.email;
    }

    public long getLast_update() {
        return this.last_update;
    }

    public String getNickname() {
        return this.nickname;
    }

    public long getUid() {
        return this.uid;
    }

    public void setActive(int r10) {
        this.active = r10;
    }

    public void setAvatar(String r10) {
        this.avatar = r10;
    }

    public void setAvatar_url(String r10) {
        this.avatar_url = r10;
    }

    public void setCellphone(String r10) {
        this.cellphone = r10;
    }

    public void setEmail(String r10) {
        this.email = r10;
    }

    public void setLast_update(long r10) {
        this.last_update = r10;
    }

    public void setNickname(String r10) {
        this.nickname = r10;
    }

    public void setUid(long r10) {
        this.uid = r10;
    }
}
