package com.stepos.mcp.sdk.base;

import H7.c;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/stepos/mcp/sdk/base/IAbility;", "R", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/stepos/mcp/sdk/base/AbilityRequest;", "request", "Lcom/stepos/mcp/sdk/base/AbilityResult;", "launch", "(Lcom/stepos/mcp/sdk/base/AbilityRequest;LH7/c;)Ljava/lang/Object;", "", "getName", "()Ljava/lang/String;", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IAbility<R, T> {
    String getName();

    Object launch(AbilityRequest<R> abilityRequest, c<? super AbilityResult<T>> cVar);
}
