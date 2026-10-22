package com.networknt.schema.walk;

import com.networknt.schema.Error;
import java.util.List;

/* loaded from: classes2.dex */
public interface WalkListener {
    void onWalkEnd(WalkEvent walkEvent, List<Error> list);

    WalkFlow onWalkStart(WalkEvent walkEvent);
}
