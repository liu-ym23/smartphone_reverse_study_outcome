package com.networknt.schema.result;

import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.result.InstanceResults;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: classes2.dex */
public class InstanceResults {
    private final Map<NodePath, List<InstanceResult>> values = new HashMap();

    public static /* synthetic */ List a(NodePath nodePath) {
        return new ArrayList();
    }

    public boolean isValid(NodePath nodePath, NodePath nodePath2) {
        List<InstanceResult> list = this.values.get(nodePath);
        if (list == null) {
            return true;
        }
        for (InstanceResult instanceResult : list) {
            if (nodePath2.startsWith(instanceResult.getEvaluationPath()) && !instanceResult.isValid()) {
                return false;
            }
        }
        return true;
    }

    public void setResult(NodePath nodePath, SchemaLocation schemaLocation, NodePath nodePath2, boolean z10) {
        this.values.computeIfAbsent(nodePath, new Function() { // from class: S3.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return InstanceResults.a((NodePath) obj);
            }
        }).add(new InstanceResult(nodePath, schemaLocation, nodePath2, z10));
    }
}
