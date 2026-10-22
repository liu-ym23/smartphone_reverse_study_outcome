package com.stepos.ability.mcpserver.handshake;

import dagger.hilt.EntryPoint;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import h4.C1486a;
import i4.C1554b;
import k4.d;
import k4.n;
import k4.z;
import kotlin.Metadata;

@EntryPoint
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/stepos/ability/mcpserver/handshake/McpHandshakeEntryPoint;", "", "Li4/b;", "monitor", "()Li4/b;", "Lk4/z;", "serverNonce", "()Lk4/z;", "Lk4/d;", "identityResolver", "()Lk4/d;", "Lk4/n;", "identityRegistry", "()Lk4/n;", "Lh4/a;", "handshakeGate", "()Lh4/a;", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@InstallIn({SingletonComponent.class})
/* loaded from: classes3.dex */
public interface McpHandshakeEntryPoint {
    C1486a handshakeGate();

    n identityRegistry();

    d identityResolver();

    C1554b monitor();

    z serverNonce();
}
