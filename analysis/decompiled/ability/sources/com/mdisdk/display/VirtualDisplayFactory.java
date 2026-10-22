package com.mdisdk.display;

import D7.v;
import android.annotation.SuppressLint;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.hardware.display.VirtualDisplayConfig;
import android.view.Surface;
import androidx.appfunctions.metadata.a;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.mdisdk.base.ALog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002*+B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0014\u0010 \u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u001bR\u0014\u0010!\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\u001bR\u0014\u0010\"\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010\u001bR\u0014\u0010#\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\u001bR\u0014\u0010$\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010\u001bR\u0014\u0010%\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010\u001bR\u0014\u0010&\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010\u001bR\u0014\u0010'\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010\u001bR\u0014\u0010(\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b(\u0010\u001bR\u0014\u0010)\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b)\u0010\u001b¨\u0006,"}, d2 = {"Lcom/mdisdk/display/VirtualDisplayFactory;", "", AppAgent.CONSTRUCT, "()V", "Landroid/hardware/display/DisplayManager;", "manager", "Lcom/mdisdk/display/VirtualDisplayFactory$VirtualDisplayConfig;", "config", "Landroid/hardware/display/VirtualDisplay;", "mirrorDisplay", "(Landroid/hardware/display/DisplayManager;Lcom/mdisdk/display/VirtualDisplayFactory$VirtualDisplayConfig;)Landroid/hardware/display/VirtualDisplay;", "", "dp", "densityDpi", "", "dpToPx", "(II)F", "Lkotlin/Function1;", "Lcom/mdisdk/display/VirtualDisplayFactory$VirtualDisplayBuilder;", "LC7/r;", "block", "createVirtualDisplay", "(Landroid/hardware/display/DisplayManager;LS7/k;)Landroid/hardware/display/VirtualDisplay;", "", "TAG", "Ljava/lang/String;", "VIRTUAL_DISPLAY_FLAG_PRESENTATION", "I", "VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR", "VIRTUAL_DISPLAY_FLAG_SECURE", "VIRTUAL_DISPLAY_FLAG_PUBLIC", "VIRTUAL_DISPLAY_FLAG_OWN_CONTENT_ONLY", "VIRTUAL_DISPLAY_FLAG_SUPPORTS_TOUCH", "VIRTUAL_DISPLAY_FLAG_ROTATES_WITH_CONTENT", "VIRTUAL_DISPLAY_FLAG_SHOULD_SHOW_SYSTEM_DECORATIONS", "VIRTUAL_DISPLAY_FLAG_TRUSTED", "VIRTUAL_DISPLAY_FLAG_OWN_DISPLAY_GROUP", "VIRTUAL_DISPLAY_FLAG_ALWAYS_UNLOCKED", "VIRTUAL_DISPLAY_FLAG_TOUCH_FEEDBACK_DISABLED", "VIRTUAL_DISPLAY_FLAG_OWN_FOCUS", "VIRTUAL_DISPLAY_FLAG_DEVICE_DISPLAY_GROUP", "VIRTUAL_DISPLAY_FLAG_QUANTUM_CAPABLE", "VirtualDisplayConfig", "VirtualDisplayBuilder", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VirtualDisplayFactory {
    public static final VirtualDisplayFactory INSTANCE = new VirtualDisplayFactory();
    private static final String TAG = "VirtualDisplayFactory";
    public static final int VIRTUAL_DISPLAY_FLAG_ALWAYS_UNLOCKED = 4096;
    public static final int VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR = 16;
    public static final int VIRTUAL_DISPLAY_FLAG_DEVICE_DISPLAY_GROUP = 32768;
    public static final int VIRTUAL_DISPLAY_FLAG_OWN_CONTENT_ONLY = 8;
    public static final int VIRTUAL_DISPLAY_FLAG_OWN_DISPLAY_GROUP = 2048;
    public static final int VIRTUAL_DISPLAY_FLAG_OWN_FOCUS = 16384;
    public static final int VIRTUAL_DISPLAY_FLAG_PRESENTATION = 2;
    public static final int VIRTUAL_DISPLAY_FLAG_PUBLIC = 1;
    public static final int VIRTUAL_DISPLAY_FLAG_QUANTUM_CAPABLE = 131072;
    public static final int VIRTUAL_DISPLAY_FLAG_ROTATES_WITH_CONTENT = 128;
    public static final int VIRTUAL_DISPLAY_FLAG_SECURE = 4;
    public static final int VIRTUAL_DISPLAY_FLAG_SHOULD_SHOW_SYSTEM_DECORATIONS = 512;
    public static final int VIRTUAL_DISPLAY_FLAG_SUPPORTS_TOUCH = 64;
    public static final int VIRTUAL_DISPLAY_FLAG_TOUCH_FEEDBACK_DISABLED = 8192;
    public static final int VIRTUAL_DISPLAY_FLAG_TRUSTED = 1024;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0012\u001a\u0004\b(\u0010\u0014\"\u0004\b)\u0010\u0016¨\u0006*"}, d2 = {"Lcom/mdisdk/display/VirtualDisplayFactory$VirtualDisplayBuilder;", "", AppAgent.CONSTRUCT, "()V", "LC7/r;", "checkParameterIfIllegal", "Lcom/mdisdk/display/VirtualDisplayFactory$VirtualDisplayConfig;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Lcom/mdisdk/display/VirtualDisplayFactory$VirtualDisplayConfig;", "", HintConstants.AUTOFILL_HINT_NAME, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "", "width", "I", "getWidth", "()I", "setWidth", "(I)V", "height", "getHeight", "setHeight", "flags", "getFlags", "setFlags", "densityDpi", "getDensityDpi", "setDensityDpi", "Landroid/view/Surface;", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "displayIdToMirror", "getDisplayIdToMirror", "setDisplayIdToMirror", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class VirtualDisplayBuilder {
        private int densityDpi;
        private int flags;
        private int height;
        private Surface surface;
        private int width;
        private String name = "";
        private int displayIdToMirror = -1;

        private final void checkParameterIfIllegal() {
            if (this.width <= 0 || this.height <= 0) {
                StringBuilder sb = new StringBuilder("Virtual display width(");
                sb.append(this.width);
                sb.append(") or height(");
                throw new IllegalArgumentException(a.o(sb, ") is illegal!", this.height));
            }
            if (this.densityDpi <= 0) {
                throw new IllegalArgumentException(a.o(new StringBuilder("Virtual display densityDpi("), ") is illegal!", this.densityDpi));
            }
            Surface surface = this.surface;
            if (surface == null) {
                throw new IllegalArgumentException("Virtual display surface is null!");
            }
            if (!surface.isValid()) {
                throw new IllegalArgumentException("Virtual display surface is invalid!");
            }
        }

        public final VirtualDisplayConfig build() {
            checkParameterIfIllegal();
            String str = this.name;
            int i = this.width;
            int i6 = this.height;
            int i10 = this.flags;
            int i11 = this.densityDpi;
            Surface surface = this.surface;
            k.c(surface);
            return new VirtualDisplayConfig(str, i, i6, i10, i11, surface, this.displayIdToMirror);
        }

        public final int getDensityDpi() {
            return this.densityDpi;
        }

        public final int getDisplayIdToMirror() {
            return this.displayIdToMirror;
        }

        public final int getFlags() {
            return this.flags;
        }

        public final int getHeight() {
            return this.height;
        }

        public final String getName() {
            return this.name;
        }

        public final Surface getSurface() {
            return this.surface;
        }

        public final int getWidth() {
            return this.width;
        }

        public final void setDensityDpi(int i) {
            this.densityDpi = i;
        }

        public final void setDisplayIdToMirror(int i) {
            this.displayIdToMirror = i;
        }

        public final void setFlags(int i) {
            this.flags = i;
        }

        public final void setHeight(int i) {
            this.height = i;
        }

        public final void setName(String str) {
            k.f(str, "<set-?>");
            this.name = str;
        }

        public final void setSurface(Surface surface) {
            this.surface = surface;
        }

        public final void setWidth(int i) {
            this.width = i;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006%"}, d2 = {"Lcom/mdisdk/display/VirtualDisplayFactory$VirtualDisplayConfig;", "", HintConstants.AUTOFILL_HINT_NAME, "", "width", "", "height", "flags", "densityDpi", "surface", "Landroid/view/Surface;", "displayIdToMirror", AppAgent.CONSTRUCT, "(Ljava/lang/String;IIIILandroid/view/Surface;I)V", "getName", "()Ljava/lang/String;", "getWidth", "()I", "getHeight", "getFlags", "getDensityDpi", "getSurface", "()Landroid/view/Surface;", "getDisplayIdToMirror", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class VirtualDisplayConfig {
        private final int densityDpi;
        private final int displayIdToMirror;
        private final int flags;
        private final int height;
        private final String name;
        private final Surface surface;
        private final int width;

        public VirtualDisplayConfig(String name, int i, int i6, int i10, int i11, Surface surface, int i12) {
            k.f(name, "name");
            k.f(surface, "surface");
            this.name = name;
            this.width = i;
            this.height = i6;
            this.flags = i10;
            this.densityDpi = i11;
            this.surface = surface;
            this.displayIdToMirror = i12;
        }

        public static /* synthetic */ VirtualDisplayConfig copy$default(VirtualDisplayConfig virtualDisplayConfig, String str, int i, int i6, int i10, int i11, Surface surface, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                str = virtualDisplayConfig.name;
            }
            if ((i13 & 2) != 0) {
                i = virtualDisplayConfig.width;
            }
            if ((i13 & 4) != 0) {
                i6 = virtualDisplayConfig.height;
            }
            if ((i13 & 8) != 0) {
                i10 = virtualDisplayConfig.flags;
            }
            if ((i13 & 16) != 0) {
                i11 = virtualDisplayConfig.densityDpi;
            }
            if ((i13 & 32) != 0) {
                surface = virtualDisplayConfig.surface;
            }
            if ((i13 & 64) != 0) {
                i12 = virtualDisplayConfig.displayIdToMirror;
            }
            Surface surface2 = surface;
            int i14 = i12;
            int i15 = i11;
            int i16 = i6;
            return virtualDisplayConfig.copy(str, i, i16, i10, i15, surface2, i14);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        /* renamed from: component3, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        /* renamed from: component4, reason: from getter */
        public final int getFlags() {
            return this.flags;
        }

        /* renamed from: component5, reason: from getter */
        public final int getDensityDpi() {
            return this.densityDpi;
        }

        /* renamed from: component6, reason: from getter */
        public final Surface getSurface() {
            return this.surface;
        }

        /* renamed from: component7, reason: from getter */
        public final int getDisplayIdToMirror() {
            return this.displayIdToMirror;
        }

        public final VirtualDisplayConfig copy(String name, int width, int height, int flags, int densityDpi, Surface surface, int displayIdToMirror) {
            k.f(name, "name");
            k.f(surface, "surface");
            return new VirtualDisplayConfig(name, width, height, flags, densityDpi, surface, displayIdToMirror);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VirtualDisplayConfig)) {
                return false;
            }
            VirtualDisplayConfig virtualDisplayConfig = (VirtualDisplayConfig) other;
            return k.b(this.name, virtualDisplayConfig.name) && this.width == virtualDisplayConfig.width && this.height == virtualDisplayConfig.height && this.flags == virtualDisplayConfig.flags && this.densityDpi == virtualDisplayConfig.densityDpi && k.b(this.surface, virtualDisplayConfig.surface) && this.displayIdToMirror == virtualDisplayConfig.displayIdToMirror;
        }

        public final int getDensityDpi() {
            return this.densityDpi;
        }

        public final int getDisplayIdToMirror() {
            return this.displayIdToMirror;
        }

        public final int getFlags() {
            return this.flags;
        }

        public final int getHeight() {
            return this.height;
        }

        public final String getName() {
            return this.name;
        }

        public final Surface getSurface() {
            return this.surface;
        }

        public final int getWidth() {
            return this.width;
        }

        public int hashCode() {
            return Integer.hashCode(this.displayIdToMirror) + ((this.surface.hashCode() + androidx.constraintlayout.core.dsl.a.a(this.densityDpi, androidx.constraintlayout.core.dsl.a.a(this.flags, androidx.constraintlayout.core.dsl.a.a(this.height, androidx.constraintlayout.core.dsl.a.a(this.width, this.name.hashCode() * 31, 31), 31), 31), 31)) * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("VirtualDisplayConfig(name=");
            sb.append(this.name);
            sb.append(", width=");
            sb.append(this.width);
            sb.append(", height=");
            sb.append(this.height);
            sb.append(", flags=");
            sb.append(this.flags);
            sb.append(", densityDpi=");
            sb.append(this.densityDpi);
            sb.append(", surface=");
            sb.append(this.surface);
            sb.append(", displayIdToMirror=");
            return B7.a.o(sb, this.displayIdToMirror, ')');
        }
    }

    private VirtualDisplayFactory() {
    }

    @SuppressLint({"NewApi"})
    private final VirtualDisplay mirrorDisplay(DisplayManager manager, VirtualDisplayConfig config) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            com.bumptech.glide.load.resource.bitmap.a.k();
            VirtualDisplayConfig.Builder builderF = com.bumptech.glide.load.resource.bitmap.a.f(config.getName(), config.getWidth(), config.getHeight(), config.getDensityDpi());
            builderF.setSurface(config.getSurface());
            builderF.setFlags(config.getFlags());
            Method[] declaredMethods = Class.forName("android.hardware.display.VirtualDisplayConfig$Builder").getDeclaredMethods();
            k.e(declaredMethods, "getDeclaredMethods(...)");
            ArrayList arrayList = new ArrayList();
            for (Method method : declaredMethods) {
                if (k.b(method.getName(), "setDisplayIdToMirror")) {
                    arrayList.add(method);
                }
            }
            Method method2 = (Method) v.C0(arrayList);
            if (method2 != null) {
                method2.setAccessible(true);
                method2.invoke(builderF, Integer.valueOf(config.getDisplayIdToMirror()));
            }
            return manager.createVirtualDisplay(builderF.build());
        } catch (Exception e) {
            ALog.e(TAG, "mirrorDisplay", e);
            return null;
        }
    }

    public final VirtualDisplay createVirtualDisplay(DisplayManager manager, S7.k block) {
        k.f(manager, "manager");
        k.f(block, "block");
        try {
            VirtualDisplayBuilder virtualDisplayBuilder = new VirtualDisplayBuilder();
            block.invoke(virtualDisplayBuilder);
            VirtualDisplayConfig virtualDisplayConfigBuild = virtualDisplayBuilder.build();
            if (virtualDisplayConfigBuild.getDisplayIdToMirror() != -1) {
                return mirrorDisplay(manager, virtualDisplayConfigBuild);
            }
            ALog.d$default(TAG, "createVirtualDisplay: " + virtualDisplayConfigBuild, null, 4, null);
            return manager.createVirtualDisplay(virtualDisplayConfigBuild.getName(), virtualDisplayConfigBuild.getWidth(), virtualDisplayConfigBuild.getHeight(), virtualDisplayConfigBuild.getDensityDpi(), virtualDisplayConfigBuild.getSurface(), virtualDisplayConfigBuild.getFlags());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final float dpToPx(int dp, int densityDpi) {
        return (densityDpi * dp) / 160;
    }
}
