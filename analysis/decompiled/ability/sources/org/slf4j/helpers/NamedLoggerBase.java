package org.slf4j.helpers;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import java.io.ObjectStreamException;
import java.io.Serializable;

/* loaded from: classes4.dex */
abstract class NamedLoggerBase implements InterfaceC0315b, Serializable {
    public Object readResolve() throws ObjectStreamException {
        return AbstractC0317d.c("NOP");
    }
}
