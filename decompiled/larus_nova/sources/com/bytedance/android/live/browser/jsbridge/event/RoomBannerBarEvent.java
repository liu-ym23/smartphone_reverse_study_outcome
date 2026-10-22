package com.bytedance.android.live.browser.jsbridge.event;

/* JADX INFO: loaded from: classes45.dex */
public class RoomBannerBarEvent {
    public static final int GONE = 0;
    public static final int VISIBLE = 1;
    private String backgroundColor;
    private String color;
    private int fontSize;
    private String title;
    private int visible;

    public boolean isVisible() {
        if (this.visible == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String toString() {
        return "RoomBannerBarEvent{title='" + this.title + "', visible=" + this.visible + ", backgroundColor='" + this.backgroundColor + "', fontSize=" + this.fontSize + ", color='" + this.color + "'}";
    }

    public RoomBannerBarEvent() {
        this.fontSize = 9;
    }

    public String getBackgroundColor() {
        return this.backgroundColor;
    }

    public String getColor() {
        return this.color;
    }

    public int getFontSize() {
        return this.fontSize;
    }

    public String getTitle() {
        return this.title;
    }

    public int getVisible() {
        return this.visible;
    }

    public void setBackgroundColor(String r100) {
        this.backgroundColor = r100;
    }

    public void setColor(String r100) {
        this.color = r100;
    }

    public void setFontSize(int r100) {
        this.fontSize = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public void setVisible(int r100) {
        this.visible = r100;
    }
}
