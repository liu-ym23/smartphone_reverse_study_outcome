package com.bytedance.ai.bridge.method.device;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/DeviceSensorInterval;", "", "sensorDelay", "", "<init>", "(Ljava/lang/String;II)V", "getSensorDelay", "()I", "GAME", "UI", EffectConstants.NORMAL, "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DeviceSensorInterval extends Enum<DeviceSensorInterval> {
    public static final a Companion = null;
    public static final DeviceSensorInterval GAME = null;
    public static final DeviceSensorInterval NORMAL = null;
    public static final DeviceSensorInterval UI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DeviceSensorInterval[] f35433a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f35434b = null;
    private final int sensorDelay;

    public static final class a {
        public a() {
        }

        public static DeviceSensorInterval a(String r100) {
            if (r100 == null) goto L4;
            String r101 = r100.toUpperCase(Locale.ROOT);
        L6:
            if (Intrinsics.areEqual(r101, "GAME") == false) goto L9;
            return DeviceSensorInterval.GAME;
        L9:
            if (Intrinsics.areEqual(r101, "UI") == false) goto L12;
            return DeviceSensorInterval.UI;
        L12:
            return DeviceSensorInterval.NORMAL;
        L4:
            r101 = null;
            goto L6
        }
    }

    public static EnumEntries<DeviceSensorInterval> getEntries() {
        return f35434b;
    }

    static {
        DeviceSensorInterval r100 = new DeviceSensorInterval("GAME", 0, 1);
        GAME = r100;
        DeviceSensorInterval r101 = new DeviceSensorInterval("UI", 1, 2);
        UI = r101;
        DeviceSensorInterval r102 = new DeviceSensorInterval(EffectConstants.NORMAL, 2, 3);
        NORMAL = r102;
        DeviceSensorInterval[] r103 = {r100, r101, r102};
        f35433a = r103;
        f35434b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static DeviceSensorInterval[] values() {
        return (DeviceSensorInterval[]) f35433a.clone();
    }

    public final int getSensorDelay() {
        return this.sensorDelay;
    }

    public static DeviceSensorInterval valueOf(String r100) {
        return (DeviceSensorInterval) r27.a.a(DeviceSensorInterval.class, r100);
    }

    public DeviceSensorInterval(String r100, int r101, int r102) {
        super(r100, r101);
        this.sensorDelay = r102;
    }
}
