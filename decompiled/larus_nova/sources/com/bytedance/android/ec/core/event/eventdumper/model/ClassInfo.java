package com.bytedance.android.ec.core.event.eventdumper.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ec/core/event/eventdumper/model/ClassInfo;", "Ljava/io/Serializable;", "()V", "classFileName", "", "getClassFileName", "()Ljava/lang/String;", "setClassFileName", "(Ljava/lang/String;)V", "line", "", "getLine", "()Ljava/lang/Integer;", "setLine", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "pkName", "getPkName", "setPkName", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ClassInfo implements Serializable {

    @SerializedName("class_file_name")
    private String classFileName;

    @SerializedName("line")
    private Integer line;

    @SerializedName("pk_name")
    private String pkName;

    public ClassInfo() {
    }

    public final String getClassFileName() {
        return this.classFileName;
    }

    public final Integer getLine() {
        return this.line;
    }

    public final String getPkName() {
        return this.pkName;
    }

    public final void setClassFileName(String r100) {
        this.classFileName = r100;
    }

    public final void setLine(Integer r100) {
        this.line = r100;
    }

    public final void setPkName(String r100) {
        this.pkName = r100;
    }
}
