package com.stepos.taskrobot.taskmanager.experiencelib.api;

import F9.P;
import H7.c;
import com.stepos.taskrobot.taskmanager.experiencelib.model.DeleteExperienceRequest;
import com.stepos.taskrobot.taskmanager.experiencelib.model.DeleteExperienceResponse;
import com.stepos.taskrobot.taskmanager.experiencelib.model.ExperienceRequest;
import com.stepos.taskrobot.taskmanager.experiencelib.model.ExperienceSearchRequest;
import com.stepos.taskrobot.taskmanager.experiencelib.model.SearchExperienceResult;
import com.stepos.taskrobot.taskmanager.experiencelib.model.Step2RetrieveRequest;
import com.stepos.taskrobot.taskmanager.experiencelib.model.Step2RetrieveResult;
import kotlin.Metadata;
import qa.L;
import sa.InterfaceC1926a;
import sa.k;
import sa.o;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\bH§@¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\fH§@¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0010H§@¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/stepos/taskrobot/taskmanager/experiencelib/api/ExperienceApi;", "", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/ExperienceSearchRequest;", "request", "Lqa/L;", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/SearchExperienceResult;", "searchExperience", "(Lcom/stepos/taskrobot/taskmanager/experiencelib/model/ExperienceSearchRequest;LH7/c;)Ljava/lang/Object;", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/DeleteExperienceRequest;", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/DeleteExperienceResponse;", "deleteExperience", "(Lcom/stepos/taskrobot/taskmanager/experiencelib/model/DeleteExperienceRequest;LH7/c;)Ljava/lang/Object;", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/ExperienceRequest;", "LF9/P;", "injectExperience", "(Lcom/stepos/taskrobot/taskmanager/experiencelib/model/ExperienceRequest;LH7/c;)Ljava/lang/Object;", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveRequest;", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult;", "retrieveStep2", "(Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveRequest;LH7/c;)Ljava/lang/Object;", "experiencelib_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ExperienceApi {
    @k({"Content-Type: application/json"})
    @o("experience/delete")
    Object deleteExperience(@InterfaceC1926a DeleteExperienceRequest deleteExperienceRequest, c<? super L<DeleteExperienceResponse>> cVar);

    @k({"Content-Type: application/json"})
    @o("experience/inject")
    Object injectExperience(@InterfaceC1926a ExperienceRequest experienceRequest, c<? super L<P>> cVar);

    @k({"Content-Type: application/json"})
    @o("v1/retrieve-step2")
    Object retrieveStep2(@InterfaceC1926a Step2RetrieveRequest step2RetrieveRequest, c<? super L<Step2RetrieveResult>> cVar);

    @k({"Content-Type: application/json"})
    @o("experience/search")
    Object searchExperience(@InterfaceC1926a ExperienceSearchRequest experienceSearchRequest, c<? super L<SearchExperienceResult>> cVar);
}
