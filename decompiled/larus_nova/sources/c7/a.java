package c7;

import android.os.Bundle;
import b7.b;
import com.bytedance.android.annie.api.param.AnnieViewType;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public class a {
    private int annieIsCard;
    private int annieIsPreRender;
    private final Bundle bundle;
    private b commonLifecycle;
    private String containerId;
    private boolean isFromFlow;
    private volatile String monitorID;
    private String type;
    private String url;
    private final String uuid;
    private AnnieViewType viewType;

    private final String generateID() {
        StringBuilder r100 = new StringBuilder();
        r100.append(System.currentTimeMillis());
        r100.append('-');
        r100.append(UUID.randomUUID());
        return r100.toString();
    }

    public final String getBizKey() {
        Bundle r100 = this.bundle;     // Catch: Throwable -> L10
        if (r100 == null) goto L13;
        String r101 = r100.getString("biz_key");     // Catch: Throwable -> L10
        if (r101 != null) goto L9;
        return "host";
    L9:
        return r101;
    L13:
        return "host";
    L15:
        return "host";
    }

    public final int getAnnieIsCard() {
        return this.annieIsCard;
    }

    public final int getAnnieIsPreRender() {
        return this.annieIsPreRender;
    }

    public final Bundle getBundle() {
        return this.bundle;
    }

    public final b getCommonLifecycle() {
        return this.commonLifecycle;
    }

    public final String getContainerId() {
        return this.containerId;
    }

    public final String getMonitorID() {
        return this.monitorID;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final AnnieViewType getViewType() {
        return this.viewType;
    }

    public final boolean isFromFlow() {
        return this.isFromFlow;
    }

    public final void setAnnieIsCard(int r100) {
        this.annieIsCard = r100;
    }

    public final void setAnnieIsPreRender(int r100) {
        this.annieIsPreRender = r100;
    }

    public final void setCommonLifecycle(b r100) {
        this.commonLifecycle = r100;
    }

    public final void setContainerId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.containerId = r100;
    }

    public final void setFromFlow(boolean r100) {
        this.isFromFlow = r100;
    }

    public final void setMonitorID(String r100) {
        this.monitorID = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }

    public final void setViewType(AnnieViewType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.viewType = r100;
    }

    public a(b r100, Bundle r101, String r102) {
        this.commonLifecycle = r100;
        this.bundle = r101;
        this.type = "";
        this.viewType = AnnieViewType.CARD;
        this.annieIsCard = -1;
        String r103 = generateID();
        this.containerId = r103;
        if (r102 != null) goto L5;
        r102 = r103;
    L5:
        this.uuid = r102;
    }
}
