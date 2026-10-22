package com.stepos.ability.commoninternal.ability;

import H7.c;
import com.stepos.ability.bean.AbilityMetadataParcelable;
import com.stepos.ability.bean.AbilityQueryParamsParcelable;
import com.stepos.ability.beaninternal.ability.AbilityMetaDataReq;
import com.stepos.ability.beaninternal.ability.AbilityMetaDataResult;
import com.stepos.ability.beaninternal.ability.AiActivityWidgetInfo;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0006J4\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH¦@¢\u0006\u0004\b\r\u0010\u000eJ2\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010H¦@¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/stepos/ability/commoninternal/ability/IAbilityManager;", "Lcom/stepos/ability/commoninternal/ability/IComponent;", "Lcom/stepos/ability/beaninternal/ability/AbilityMetaDataReq;", "request", "Lcom/stepos/ability/beaninternal/ability/AbilityMetaDataResult;", "getAbilityMetaData", "(Lcom/stepos/ability/beaninternal/ability/AbilityMetaDataReq;LH7/c;)Ljava/lang/Object;", "", GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, "", "", "extra", "Lcom/stepos/ability/beaninternal/ability/AiActivityWidgetInfo;", "getCreateAiActivityWidgetInfo", "(Ljava/lang/String;Ljava/util/Map;LH7/c;)Ljava/lang/Object;", "query", "", "Lcom/stepos/ability/bean/AbilityQueryParamsParcelable;", "params", "Lcom/stepos/ability/bean/AbilityMetadataParcelable;", "queryAbilities", "(Ljava/lang/String;Ljava/util/List;LH7/c;)Ljava/lang/Object;", "commonInternal_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IAbilityManager extends IComponent {
    Object getAbilityMetaData(AbilityMetaDataReq abilityMetaDataReq, c<? super AbilityMetaDataResult> cVar);

    Object getCreateAiActivityWidgetInfo(String str, Map<String, ? extends Object> map, c<? super AiActivityWidgetInfo> cVar);

    Object queryAbilities(String str, List<AbilityQueryParamsParcelable> list, c<? super List<AbilityMetadataParcelable>> cVar);
}
