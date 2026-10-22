package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import androidx.annotation.Keep;
import com.obric.capabilitykit.entity.app.AppEntity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B/\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/obric/capabilitykit/entity/app/EntityClassData;", "T", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "", "clazz", "Ljava/lang/Class;", "version", "", "parcelConstructor", "Lkotlin/Function1;", "Landroid/os/Parcel;", "(Ljava/lang/Class;ILkotlin/jvm/functions/Function1;)V", "getClazz", "()Ljava/lang/Class;", "getParcelConstructor", "()Lkotlin/jvm/functions/Function1;", "getVersion", "()I", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityClassData<T extends AppEntity> {

    @NotNull
    private final Class<T> clazz;

    @NotNull
    private final Function1<Parcel, T> parcelConstructor;
    private final int version;

    /* JADX WARN: Multi-variable type inference failed */
    public EntityClassData(@NotNull Class<T> r10, int r11, @NotNull Function1<? super Parcel, ? extends T> r12) {
        q.g(r10, "clazz");
        q.g(r12, "parcelConstructor");
        this.clazz = r10;
        this.version = r11;
        this.parcelConstructor = r12;
    }

    @NotNull
    public final Class<T> getClazz() {
        return this.clazz;
    }

    @NotNull
    public final Function1<Parcel, T> getParcelConstructor() {
        return this.parcelConstructor;
    }

    public final int getVersion() {
        return this.version;
    }
}
