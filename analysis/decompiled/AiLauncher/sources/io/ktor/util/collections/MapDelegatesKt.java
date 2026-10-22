package io.ktor.util.collections;

import La.r;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.utils.io.InternalAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import w9.InterfaceC5752k;

@Metadata(d1 = {"\u0000*\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a*\u0010\u0005\u001a\u0004\u0018\u00010\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0087\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a2\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0000H\u0087\u0002¢\u0006\u0004\b\t\u0010\n\u001a6\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0087\u0002¢\u0006\u0004\b\u0005\u0010\r\u001a>\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000H\u0087\u0002¢\u0006\u0004\b\t\u0010\u000e\u001a\u0019\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\f*\u00020\u0000H\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"", "Lio/ktor/util/collections/StringMap;", "thisRef", "Lw9/k;", "property", "getValue", "(Ljava/lang/String;Lio/ktor/util/collections/StringMap;Lw9/k;)Ljava/lang/String;", UxipConstants.f30680s, "LY8/t;", "setValue", "(Ljava/lang/String;Lio/ktor/util/collections/StringMap;Lw9/k;Ljava/lang/String;)V", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/util/collections/SerializedMapValue;", "(Lio/ktor/util/collections/SerializedMapValue;Lio/ktor/util/collections/StringMap;Lw9/k;)Ljava/lang/Object;", "(Lio/ktor/util/collections/SerializedMapValue;Lio/ktor/util/collections/StringMap;Lw9/k;Ljava/lang/Object;)V", "", "asBoolean", "(Ljava/lang/String;)Lio/ktor/util/collections/SerializedMapValue;", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MapDelegatesKt {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.util.collections.MapDelegatesKt$asBoolean$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements InterfaceC5074l<Boolean, String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1, Boolean.TYPE, "toString", "toString()Ljava/lang/String;", 0);
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ String invoke(Boolean bool) {
            return invoke(bool.booleanValue());
        }

        public final String invoke(boolean z10) {
            return String.valueOf(z10);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.util.collections.MapDelegatesKt$asBoolean$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements InterfaceC5074l<String, Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1, r.class, "toBoolean", "toBoolean(Ljava/lang/String;)Z", 1);
        }

        @Override // p9.InterfaceC5074l
        public final Boolean invoke(String p02) {
            p.i(p02, "p0");
            return Boolean.valueOf(Boolean.parseBoolean(p02));
        }
    }

    @InternalAPI
    public static final SerializedMapValue<Boolean> asBoolean(String str) {
        p.i(str, "<this>");
        return new SerializedMapValue<>(str, AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE);
    }

    @InternalAPI
    public static final String getValue(String str, StringMap thisRef, InterfaceC5752k<?> property) {
        p.i(str, "<this>");
        p.i(thisRef, "thisRef");
        p.i(property, "property");
        return thisRef.get(str);
    }

    @InternalAPI
    public static final void setValue(String str, StringMap thisRef, InterfaceC5752k<?> property, String str2) {
        p.i(str, "<this>");
        p.i(thisRef, "thisRef");
        p.i(property, "property");
        if (str2 == null) {
            thisRef.remove(str);
        } else {
            thisRef.set(str, str2);
        }
    }

    @InternalAPI
    public static final <T> T getValue(SerializedMapValue<T> serializedMapValue, StringMap thisRef, InterfaceC5752k<?> property) {
        p.i(serializedMapValue, "<this>");
        p.i(thisRef, "thisRef");
        p.i(property, "property");
        String str = thisRef.get(serializedMapValue.getKey());
        if (str != null) {
            return serializedMapValue.getDeserialize$ktor_utils().invoke(str);
        }
        return null;
    }

    @InternalAPI
    public static final <T> void setValue(SerializedMapValue<T> serializedMapValue, StringMap thisRef, InterfaceC5752k<?> property, T t10) {
        p.i(serializedMapValue, "<this>");
        p.i(thisRef, "thisRef");
        p.i(property, "property");
        if (t10 == null) {
            thisRef.remove(serializedMapValue.getKey());
        } else {
            thisRef.set(serializedMapValue.getKey(), serializedMapValue.getSerialize$ktor_utils().invoke(t10));
        }
    }
}
