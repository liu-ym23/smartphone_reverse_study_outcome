package com.bytedance.android.livehostapi.business.depend.hashtag;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class LiveHashTag implements Serializable {
    public boolean challengeTaskOptional;
    private String creationId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f102926id;
    private boolean isCustom;
    private final String name;
    private String source;
    public boolean stickerTaskOptional;
    private String taskId;
    private String taskName;
    public String taskStickerId;

    public String getCreationId() {
        return this.creationId;
    }

    public String getId() {
        return this.f102926id;
    }

    public String getName() {
        return this.name;
    }

    public String getSource() {
        return this.source;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public boolean isCustom() {
        return this.isCustom;
    }

    public void setCreationId(String r100) {
        this.creationId = r100;
    }

    public void setTaskId(String r100) {
        this.taskId = r100;
    }

    public LiveHashTag(String r100, String r101) {
        this.isCustom = false;
        this.source = "";
        this.creationId = null;
        this.challengeTaskOptional = true;
        this.stickerTaskOptional = true;
        this.f102926id = r100;
        this.name = r101;
    }

    public LiveHashTag(String r100, String r101, boolean r102, String r103) {
        this.creationId = null;
        this.challengeTaskOptional = true;
        this.stickerTaskOptional = true;
        this.f102926id = r100;
        this.name = r101;
        this.isCustom = r102;
        this.source = r103;
    }
}
