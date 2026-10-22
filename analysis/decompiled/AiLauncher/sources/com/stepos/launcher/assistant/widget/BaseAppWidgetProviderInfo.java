package com.stepos.launcher.assistant.widget;

import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.stepos.launcher.assistant.utils.Utils;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

/* loaded from: classes.dex */
public class BaseAppWidgetProviderInfo extends AppWidgetProviderInfo implements IWidgetConfigCallback {
    protected static final String TAG = "WidgetProviderInfo";
    private boolean mIsSystemWidgetInfo;
    private final WidgetConfig mWidgetConfig;
    private final WidgetDisplay mWidgetDisplay;
    private final WidgetModule mWidgetModule;

    public BaseAppWidgetProviderInfo() {
        this.mWidgetConfig = new WidgetConfig();
        this.mWidgetDisplay = new WidgetDisplay();
        this.mWidgetModule = new WidgetModule();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$parseWidgetConfig$1(Bundle bundle) {
        this.mWidgetDisplay.parse(bundle);
        this.mWidgetConfig.parse(bundle);
        this.mWidgetModule.parse(bundle);
    }

    @Override // android.appwidget.AppWidgetProviderInfo
    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // com.stepos.launcher.assistant.widget.IWidgetConfigCallback
    public String getDisplayText() {
        return this.mWidgetDisplay.getDisplayText();
    }

    @Override // com.stepos.launcher.assistant.widget.IWidgetConfigCallback
    public String getModule() {
        return this.mWidgetModule.getModule();
    }

    @Override // com.stepos.launcher.assistant.widget.IWidgetConfigCallback
    public String getWidgetConfigText() {
        return this.mWidgetConfig.getWidgetConfigText();
    }

    @Override // com.stepos.launcher.assistant.widget.IWidgetConfigCallback
    public boolean isAssistantFilter() {
        return this.mWidgetConfig.isAssistantFilter();
    }

    @Override // com.stepos.launcher.assistant.widget.IWidgetConfigCallback
    public boolean isBlurBg() {
        return this.mWidgetConfig.isBlurBg();
    }

    @Override // com.stepos.launcher.assistant.widget.IWidgetConfigCallback
    public boolean isCarWidget() {
        return this.mWidgetDisplay.isCarWidget();
    }

    @Override // com.stepos.launcher.assistant.widget.IWidgetConfigCallback
    public boolean isHideTitle() {
        return this.mWidgetConfig.isHideTitle();
    }

    @Override // com.stepos.launcher.assistant.widget.IWidgetConfigCallback
    public boolean isHomeFilter() {
        return this.mWidgetConfig.isHomeFilter();
    }

    @Override // com.stepos.launcher.assistant.widget.IWidgetConfigCallback
    public boolean isMotionGlass() {
        return this.mWidgetConfig.isMotionGlass();
    }

    @Override // com.stepos.launcher.assistant.widget.IWidgetConfigCallback
    public boolean isNoAlign() {
        return this.mWidgetConfig.isNoAlign();
    }

    @Override // com.stepos.launcher.assistant.widget.IWidgetConfigCallback
    public boolean isPhoneWidget() {
        return this.mWidgetDisplay.isPhoneWidget();
    }

    @Override // com.stepos.launcher.assistant.widget.IWidgetConfigCallback
    public boolean isPreviewNoPadding() {
        return this.mWidgetConfig.isPreviewNoPadding();
    }

    @Override // com.stepos.launcher.assistant.widget.IWidgetConfigCallback
    public boolean isStepOSAlign() {
        return this.mWidgetConfig.isStepOSAlign();
    }

    @Override // com.stepos.launcher.assistant.widget.IWidgetConfigCallback
    public boolean isSubWidget() {
        return this.mWidgetDisplay.isSubWidget();
    }

    @Override // com.stepos.launcher.assistant.widget.IWidgetConfigCallback
    public boolean isSystemWidgetInfo() {
        return this.mIsSystemWidgetInfo;
    }

    @Override // com.stepos.launcher.assistant.widget.IWidgetConfigCallback
    public boolean isThirdPartyAlign() {
        return this.mWidgetConfig.isThirdPartyAlign();
    }

    public void parseWidgetConfig(Context context) {
        Optional.ofNullable(getActivityInfo()).map(new Function() { // from class: com.stepos.launcher.assistant.widget.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ActivityInfo) obj).metaData;
            }
        }).ifPresent(new Consumer() { // from class: com.stepos.launcher.assistant.widget.b
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f30170a.lambda$parseWidgetConfig$1((Bundle) obj);
            }
        });
        this.mIsSystemWidgetInfo = Utils.isSystemWidgetInfo(context, this);
    }

    public BaseAppWidgetProviderInfo(Parcel parcel) {
        super(parcel);
        this.mWidgetConfig = new WidgetConfig();
        this.mWidgetDisplay = new WidgetDisplay();
        this.mWidgetModule = new WidgetModule();
    }
}
