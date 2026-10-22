package com.stepos.ability;

import com.stepos.ability.mcpserver.handshake.McpHandshakeEntryPoint;
import com.stepos.ability.service.invoke.AbilityInvokeEntryPoint;
import dagger.hilt.android.flags.FragmentGetContextFix;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint;
import dagger.hilt.android.internal.managers.ServiceComponentManager;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedComponent;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public abstract class App_HiltComponents$SingletonC implements App_GeneratedInjector, McpHandshakeEntryPoint, AbilityInvokeEntryPoint, FragmentGetContextFix.FragmentGetContextFixEntryPoint, HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint, ServiceComponentManager.ServiceComponentBuilderEntryPoint, SingletonComponent, GeneratedComponent {
}
