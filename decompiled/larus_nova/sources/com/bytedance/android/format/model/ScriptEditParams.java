package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/format/model/ScriptEditParams;", "Ljava/io/Serializable;", "()V", "editPageSchemaDebug", "", "getEditPageSchemaDebug", "()Ljava/lang/String;", "setEditPageSchemaDebug", "(Ljava/lang/String;)V", "editPageSchemaRelease", "getEditPageSchemaRelease", "setEditPageSchemaRelease", "enableScriptEdit", "", "getEnableScriptEdit", "()Z", "setEnableScriptEdit", "(Z)V", "enableStyleRewrite", "getEnableStyleRewrite", "setEnableStyleRewrite", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScriptEditParams implements Serializable {

    @SerializedName("edit_page_schema_debug")
    private String editPageSchemaDebug;

    @SerializedName("edit_page_schema_release")
    private String editPageSchemaRelease;

    @SerializedName("enable_script_edit")
    private boolean enableScriptEdit;

    @SerializedName("enable_style_rewrite")
    private boolean enableStyleRewrite;

    public ScriptEditParams() {
    }

    public final String getEditPageSchemaDebug() {
        return this.editPageSchemaDebug;
    }

    public final String getEditPageSchemaRelease() {
        return this.editPageSchemaRelease;
    }

    public final boolean getEnableScriptEdit() {
        return this.enableScriptEdit;
    }

    public final boolean getEnableStyleRewrite() {
        return this.enableStyleRewrite;
    }

    public final void setEditPageSchemaDebug(String r100) {
        this.editPageSchemaDebug = r100;
    }

    public final void setEditPageSchemaRelease(String r100) {
        this.editPageSchemaRelease = r100;
    }

    public final void setEnableScriptEdit(boolean r100) {
        this.enableScriptEdit = r100;
    }

    public final void setEnableStyleRewrite(boolean r100) {
        this.enableStyleRewrite = r100;
    }
}
