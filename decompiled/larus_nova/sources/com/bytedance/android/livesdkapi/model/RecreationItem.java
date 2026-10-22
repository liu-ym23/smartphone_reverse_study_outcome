package com.bytedance.android.livesdkapi.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class RecreationItem {
    public static final int ID_DRIVE = 2;
    public static final int ID_TURN_TABLE = 1;

    @SerializedName("description")
    private String description;

    @SerializedName("highlighted_drive_icon_url")
    private String driveNewIcon;

    @SerializedName("icon_url")
    private String iconUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private int f162636id;

    @SerializedName("red_dot")
    private int redDotId;

    @SerializedName(a.KEY_SCHEMA_URL)
    private String schemaUrl;

    public RecreationItem() {
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public int getId() {
        return this.f162636id;
    }

    public int getRedDotId() {
        return this.redDotId;
    }

    public String getSchemaUrl() {
        return this.schemaUrl;
    }
}
