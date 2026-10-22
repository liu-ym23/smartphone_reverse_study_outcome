package com.stepos.motionkit.fx.uniform;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u0012J-\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u0014J5\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u0016J%\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010!\u001a\u00020 ¢\u0006\u0004\b!\u0010\"J\u0013\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060#¢\u0006\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R \u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R \u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010,¨\u0006."}, d2 = {"Lcom/stepos/motionkit/fx/uniform/UniformBuffer;", "", "", "capacity", AppAgent.CONSTRUCT, "(I)V", "", HintConstants.AUTOFILL_HINT_NAME, "floatCount", "allocate", "(Ljava/lang/String;I)I", "", "value", "LC7/r;", "set", "(Ljava/lang/String;F)V", "x", "y", "(Ljava/lang/String;FF)V", "z", "(Ljava/lang/String;FFF)V", "w", "(Ljava/lang/String;FFFF)V", "component", "setComponent", "(Ljava/lang/String;IF)V", "get", "(Ljava/lang/String;)F", "getOffset", "(Ljava/lang/String;)Ljava/lang/Integer;", "getFloatCount", "(Ljava/lang/String;)I", "", "getRawArray", "()[F", "", "getNames", "()Ljava/util/Set;", SettingsConfig.KEY_DATA, "[F", "size", "I", "", "nameToOffset", "Ljava/util/Map;", "nameToSize", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UniformBuffer {
    private float[] data;
    private final Map<String, Integer> nameToOffset;
    private final Map<String, Integer> nameToSize;
    private int size;

    public UniformBuffer() {
        this(0, 1, null);
    }

    public final int allocate(String name, int floatCount) {
        k.f(name, "name");
        int i = this.size;
        int i6 = i + floatCount;
        float[] fArr = this.data;
        if (i6 > fArr.length) {
            int length = fArr.length * 2;
            int i10 = i + floatCount;
            if (length < i10) {
                length = i10;
            }
            float[] fArrCopyOf = Arrays.copyOf(fArr, length);
            k.e(fArrCopyOf, "copyOf(...)");
            this.data = fArrCopyOf;
        }
        this.nameToOffset.put(name, Integer.valueOf(i));
        this.nameToSize.put(name, Integer.valueOf(floatCount));
        this.size += floatCount;
        return i;
    }

    public final float get(String name) {
        k.f(name, "name");
        Integer num = this.nameToOffset.get(name);
        if (num == null) {
            return 0.0f;
        }
        return this.data[num.intValue()];
    }

    public final int getFloatCount(String name) {
        k.f(name, "name");
        Integer num = this.nameToSize.get(name);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final Set<String> getNames() {
        return this.nameToOffset.keySet();
    }

    public final Integer getOffset(String name) {
        k.f(name, "name");
        return this.nameToOffset.get(name);
    }

    /* renamed from: getRawArray, reason: from getter */
    public final float[] getData() {
        return this.data;
    }

    public final void set(String name, float value) {
        k.f(name, "name");
        Integer num = this.nameToOffset.get(name);
        if (num != null) {
            this.data[num.intValue()] = value;
        }
    }

    public final void setComponent(String name, int component, float value) {
        k.f(name, "name");
        Integer num = this.nameToOffset.get(name);
        if (num != null) {
            this.data[num.intValue() + component] = value;
        }
    }

    public UniformBuffer(int i) {
        this.data = new float[i];
        this.nameToOffset = new LinkedHashMap();
        this.nameToSize = new LinkedHashMap();
    }

    public final void set(String name, float x10, float y) {
        k.f(name, "name");
        Integer num = this.nameToOffset.get(name);
        if (num != null) {
            int iIntValue = num.intValue();
            float[] fArr = this.data;
            fArr[iIntValue] = x10;
            fArr[iIntValue + 1] = y;
        }
    }

    public /* synthetic */ UniformBuffer(int i, int i6, e eVar) {
        this((i6 & 1) != 0 ? 64 : i);
    }

    public final void set(String name, float x10, float y, float z10) {
        k.f(name, "name");
        Integer num = this.nameToOffset.get(name);
        if (num != null) {
            int iIntValue = num.intValue();
            float[] fArr = this.data;
            fArr[iIntValue] = x10;
            fArr[iIntValue + 1] = y;
            fArr[iIntValue + 2] = z10;
        }
    }

    public final void set(String name, float x10, float y, float z10, float w8) {
        k.f(name, "name");
        Integer num = this.nameToOffset.get(name);
        if (num != null) {
            int iIntValue = num.intValue();
            float[] fArr = this.data;
            fArr[iIntValue] = x10;
            fArr[iIntValue + 1] = y;
            fArr[iIntValue + 2] = z10;
            fArr[iIntValue + 3] = w8;
        }
    }
}
