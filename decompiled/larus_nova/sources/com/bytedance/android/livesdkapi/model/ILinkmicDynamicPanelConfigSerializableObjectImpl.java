package com.bytedance.android.livesdkapi.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0016\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0016\u0010\u0013\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0016\u0010\u0017\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/ILinkmicDynamicPanelConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdkapi/model/ILinkmicDynamicPanelConfig;", "()V", "emojiPanelOpen", "", "getEmojiPanelOpen", "()Z", "emojiPanelSchema", "", "getEmojiPanelSchema", "()Ljava/lang/String;", "emojiPanelSettings", "", "getEmojiPanelSettings", "()Ljava/util/List;", "emojiPanelUrl", "getEmojiPanelUrl", "settingPanelOpen", "getSettingPanelOpen", "settingPanelSchema", "getSettingPanelSchema", "settingPanelSettings", "getSettingPanelSettings", "settingPanelUrl", "getSettingPanelUrl", "Adapter", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicDynamicPanelConfigSerializableObjectImpl implements ILinkmicDynamicPanelConfig {

    @SerializedName("emoji_panel_open")
    private final boolean emojiPanelOpen;

    @SerializedName("emoji_panel_schema")
    private final String emojiPanelSchema;

    @SerializedName("emoji_panel_settings")
    private final List<String> emojiPanelSettings;

    @SerializedName("emoji_panel_url")
    private final String emojiPanelUrl;

    @SerializedName("setting_panel_open")
    private final boolean settingPanelOpen;

    @SerializedName("setting_panel_schema")
    private final String settingPanelSchema;

    @SerializedName("setting_panel_settings")
    private final List<String> settingPanelSettings;

    @SerializedName("setting_panel_url")
    private final String settingPanelUrl;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/ILinkmicDynamicPanelConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(ILinkmicDynamicPanelConfigSerializableObjectImpl.class);
        }
    }

    public ILinkmicDynamicPanelConfigSerializableObjectImpl() {
        this.emojiPanelOpen = ILinkmicDynamicPanelConfig.DefaultImpls.getEmojiPanelOpen(this);
        this.emojiPanelUrl = ILinkmicDynamicPanelConfig.DefaultImpls.getEmojiPanelUrl(this);
        this.emojiPanelSchema = ILinkmicDynamicPanelConfig.DefaultImpls.getEmojiPanelSchema(this);
        this.emojiPanelSettings = ILinkmicDynamicPanelConfig.DefaultImpls.getEmojiPanelSettings(this);
        this.settingPanelOpen = ILinkmicDynamicPanelConfig.DefaultImpls.getSettingPanelOpen(this);
        this.settingPanelUrl = ILinkmicDynamicPanelConfig.DefaultImpls.getSettingPanelUrl(this);
        this.settingPanelSchema = ILinkmicDynamicPanelConfig.DefaultImpls.getSettingPanelSchema(this);
        this.settingPanelSettings = ILinkmicDynamicPanelConfig.DefaultImpls.getSettingPanelSettings(this);
    }

    @Override // com.bytedance.android.livesdkapi.model.ILinkmicDynamicPanelConfig
    public final boolean getEmojiPanelOpen() {
        return this.emojiPanelOpen;
    }

    @Override // com.bytedance.android.livesdkapi.model.ILinkmicDynamicPanelConfig
    public final String getEmojiPanelSchema() {
        return this.emojiPanelSchema;
    }

    @Override // com.bytedance.android.livesdkapi.model.ILinkmicDynamicPanelConfig
    public final List<String> getEmojiPanelSettings() {
        return this.emojiPanelSettings;
    }

    @Override // com.bytedance.android.livesdkapi.model.ILinkmicDynamicPanelConfig
    public final String getEmojiPanelUrl() {
        return this.emojiPanelUrl;
    }

    @Override // com.bytedance.android.livesdkapi.model.ILinkmicDynamicPanelConfig
    public final boolean getSettingPanelOpen() {
        return this.settingPanelOpen;
    }

    @Override // com.bytedance.android.livesdkapi.model.ILinkmicDynamicPanelConfig
    public final String getSettingPanelSchema() {
        return this.settingPanelSchema;
    }

    @Override // com.bytedance.android.livesdkapi.model.ILinkmicDynamicPanelConfig
    public final List<String> getSettingPanelSettings() {
        return this.settingPanelSettings;
    }

    @Override // com.bytedance.android.livesdkapi.model.ILinkmicDynamicPanelConfig
    public final String getSettingPanelUrl() {
        return this.settingPanelUrl;
    }
}
